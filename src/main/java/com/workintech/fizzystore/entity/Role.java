package com.workintech.fizzystore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role", schema = "fizzy")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != getClass())
            return false;

        Role role = (Role)obj;

        return role.getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
