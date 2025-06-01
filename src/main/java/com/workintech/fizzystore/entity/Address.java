package com.workintech.fizzystore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address", schema = "fizzy")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(max = 50)
    private String title;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(name = "surname")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    private String surname;

    @Column(name = "phone_number")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 14)
    private String phoneNumber;

    @Column(name = "city")
    @NotNull
    @NotEmpty
    @NotBlank
    private String city;

    @Column(name = "district")
    @NotNull
    @NotEmpty
    @NotBlank
    private String district;

    @Column(name = "neighborhood")
    @NotNull
    @NotEmpty
    @NotBlank
    private String neighborhood;

    @Column(name = "address")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 300)
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object obj) {
        if ( obj == this)
            return true;

        if ( obj == null || obj.getClass() != getClass())
            return false;

        Address address = (Address) obj;

        return address.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}
