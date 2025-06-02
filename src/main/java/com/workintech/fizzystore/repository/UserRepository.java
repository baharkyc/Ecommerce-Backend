package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT FROM User u WHERE u.email = :email")
    Optional <User> findByEmail(@Param("email") String email);


}
