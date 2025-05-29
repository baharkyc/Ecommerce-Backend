package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.CreditCard;
import com.workintech.fizzystore.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order findById(Long id);
    Order create(Order order);
    Order update(Long id, Order order);
    void deleteById(Long id);
}
