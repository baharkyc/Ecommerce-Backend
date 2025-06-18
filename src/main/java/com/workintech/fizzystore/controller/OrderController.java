package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.*;
import com.workintech.fizzystore.entity.Order;
import com.workintech.fizzystore.service.OrderService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<OrderResponseDto> getOrders() {
        return orderService.getAll()
                .stream()
                .map(order -> new OrderResponseDto(
                        order.getId(),
                        order.getUser().getId(),
                        order.getAddressId(),
                        order.getOrderDate(),
                        order.getCreditCard().getId(),
                        order.getPrice(),
                        order.getProducts()
                )).toList();
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@Positive @PathVariable Long id) {
        Order order = orderService.findById(id);

        return new OrderResponseDto(
                order.getId(),
                order.getUser().getId(),
                order.getAddressId(),
                order.getOrderDate(),
                order.getCreditCard().getId(),
                order.getPrice(),
                order.getProducts()
        );
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED) //201
    public OrderResponseDto saveOrder(@Validated @RequestBody OrderRequestDto orderRequestDto) {

        Order order = new Order();
        order.setUser(orderRequestDto.getUser());
        order.setAddressId(orderRequestDto.getAddressId());
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setCreditCard(orderRequestDto.getCreditCard());
        order.setPrice(orderRequestDto.getPrice());
        order.setProducts(orderRequestDto.getProducts());

        Order savedOrder = orderService.create(order);

        return new OrderResponseDto(
                order.getId(),
                order.getUser().getId(),
                order.getAddressId(),
                order.getOrderDate(),
                order.getCreditCard().getId(),
                order.getPrice(),
                order.getProducts()
        );
    }



}
