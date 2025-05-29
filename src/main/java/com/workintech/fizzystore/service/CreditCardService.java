package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.CreditCard;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAll();
    CreditCard findById(Long id);
    CreditCard create(CreditCard creditCard);
    CreditCard update(Long id, CreditCard creditCard);
    void deleteById(Long id);
}
