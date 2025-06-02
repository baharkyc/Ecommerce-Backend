package com.workintech.fizzystore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_on_card")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 100)
    private String nameOnCard;

    @Column(name = "card_no")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 24)
    private String cardNo;

    @Column(name = "expire_month")
    private Long expireMonth;

    @Column(name = "expire_year")
    private String expireYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "creditCard",cascade = CascadeType.ALL)
    private List<Order> ordersList;

}
