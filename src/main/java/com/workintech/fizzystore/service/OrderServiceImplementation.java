package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Order;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImplementation implements OrderService{

    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Order with id: " + id + " not found.", HttpStatus.NOT_FOUND));
        return order;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Order with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (order.getAddressId() != null) {
            orderToUpdate.setAddressId(order.getAddressId());
        }
        if (order.getOrderDate() != null) {
            orderToUpdate.setOrderDate(order.getOrderDate());
        }
        if (order.getCreditCard() != null) {
            orderToUpdate.setCreditCard(order.getCreditCard());
        }
        if (order.getPrice() != null) {
            orderToUpdate.setPrice(order.getPrice());
        }
        if (order.getProducts() != null) {
            orderToUpdate.setProducts(order.getProducts());
        }
        if (order.getUser() != null) {
            orderToUpdate.setUser(order.getUser());
        }

        return orderRepository.save(orderToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(!orderRepository.existsById(id)) {
            throw new FizzyStoreException("Order with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        orderRepository.deleteById(id);
    }
}
