package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();
    Address findById(Long id);
    Address create(Address address);
    Address update(Long id, Address address);
    void deleteById(Long id);
}
