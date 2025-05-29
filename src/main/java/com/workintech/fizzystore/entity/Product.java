package com.workintech.fizzystore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product", schema = "fizzy")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "category_id")
    private Long categoryId;

    @NotNull
    @Column(name = "rating")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    private Float rating;

    @NotNull
    @ElementCollection
    @Column(name = "images")
    private  List<String> images;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

}
