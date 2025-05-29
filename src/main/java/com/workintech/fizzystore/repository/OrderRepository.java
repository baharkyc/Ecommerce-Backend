package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
