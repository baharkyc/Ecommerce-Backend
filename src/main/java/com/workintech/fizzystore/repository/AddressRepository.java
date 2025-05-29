package com.workintech.fizzystore.repository;

import com.workintech.fizzystore.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Long> {
}
