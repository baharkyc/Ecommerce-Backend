package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
