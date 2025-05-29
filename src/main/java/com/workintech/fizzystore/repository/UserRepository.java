package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
