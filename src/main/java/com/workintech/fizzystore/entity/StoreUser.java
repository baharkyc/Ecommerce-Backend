package com.workintech.fizzystore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // Don't show password
@Entity
@Table(name = "store_user")
public class StoreUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @Column(name = "password")
    @NotNull
    @NotBlank
    @NotEmpty
    @JsonIgnore
    private String password;

    @Column(name = "role_id")
    @NotNull
    private Long roleId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tax_no")
    private String taxNo;

    @Column(name = "bank_account")
    private String bankAccount;

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != getClass())
            return false;

        StoreUser user = (StoreUser) obj;

        return Objects.equals(user.getId(), this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
