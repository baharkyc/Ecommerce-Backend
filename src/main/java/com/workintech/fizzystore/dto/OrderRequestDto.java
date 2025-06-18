package com.workintech.fizzystore.dto;

import com.workintech.fizzystore.entity.CreditCard;
import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private User user;

    private Long addressId;

    private String orderDate;

    private CreditCard creditCard;

    private BigDecimal price;

    private List<Product> products;


}
