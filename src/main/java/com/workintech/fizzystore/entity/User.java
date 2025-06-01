package com.workintech.fizzystore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password") // Don't show password
@Entity
@Table(name = "user", schema = "fizzy")
public class User {

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

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CreditCard> creditCardList;

    @Override
    public boolean equals(Object obj) {
        if ( obj == this)
            return true;

        if ( obj == null || obj.getClass() != getClass())
            return false;

        User user = (User) obj;

        return user.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

}
