package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.AddressRequestDto;
import com.workintech.fizzystore.dto.AddressResponseDto;
import com.workintech.fizzystore.entity.Address;
import com.workintech.fizzystore.service.AddressService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public List<AddressResponseDto> getAddresses() {
        return addressService
                .getAll()
                .stream()
                .map(address -> new AddressResponseDto(
                        address.getId(),
                        address.getTitle(),
                        address.getName(),
                        address.getSurname(),
                        address.getPhoneNumber(),
                        address.getCity(),
                        address.getDistrict(),
                        address.getNeighborhood(),
                        address.getAddress()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public AddressResponseDto getAddressById(@Positive @PathVariable Long id) {
        Address address = addressService.findById(id);

        return new AddressResponseDto(address.getId(),
                address.getTitle(),
                address.getName(),
                address.getSurname(),
                address.getPhoneNumber(),
                address.getCity(),
                address.getDistrict(),
                address.getNeighborhood(),
                address.getAddress());
    }

    @PostMapping("")
    public AddressResponseDto addAddress(@Validated @RequestBody AddressRequestDto addressRequestDto) {

        Address address = getAddress(addressRequestDto);

        Address savedAddress = addressService.create(address);

        return new AddressResponseDto(address.getId(),
                address.getTitle(),
                address.getName(),
                address.getSurname(),
                address.getPhoneNumber(),
                address.getCity(),
                address.getDistrict(),
                address.getNeighborhood(),
                address.getAddress());

    }

    private static Address getAddress(AddressRequestDto addressRequestDto) {
        Address address = new Address();

        address.setTitle(addressRequestDto.getTitle());
        address.setName(addressRequestDto.getName());
        address.setSurname(addressRequestDto.getSurname());
        address.setPhoneNumber(addressRequestDto.getPhoneNumber());
        address.setCity(addressRequestDto.getCity());
        address.setDistrict(addressRequestDto.getDistrict());
        address.setNeighborhood(addressRequestDto.getNeighborhood());
        address.setAddress(addressRequestDto.getAddress());
        return address;
    }

    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(@Positive @PathVariable Long id, @Validated @RequestBody AddressRequestDto addressRequestDto) {

        Address address = new Address();

        if(addressRequestDto.getTitle() != null)
            address.setTitle(addressRequestDto.getTitle());

        if(addressRequestDto.getName() != null)
            address.setName(addressRequestDto.getName());

        if(addressRequestDto.getSurname() != null)
            address.setSurname(addressRequestDto.getSurname());

        if(addressRequestDto.getPhoneNumber() != null)
            address.setPhoneNumber(addressRequestDto.getPhoneNumber());

        if(addressRequestDto.getCity() != null)
            address.setCity(addressRequestDto.getCity());

        if(addressRequestDto.getDistrict() != null)
            address.setDistrict(addressRequestDto.getDistrict());

        if(addressRequestDto.getNeighborhood() != null)
            address.setNeighborhood(addressRequestDto.getNeighborhood());

        if(addressRequestDto.getAddress() != null)
            address.setAddress(addressRequestDto.getAddress());

        Address updatedAddress = addressService.update(id, address);

        return new AddressResponseDto(updatedAddress.getId(),
                updatedAddress.getTitle(),
                updatedAddress.getName(),
                updatedAddress.getSurname(),
                updatedAddress.getPhoneNumber(),
                updatedAddress.getCity(),
                updatedAddress.getDistrict(),
                updatedAddress.getNeighborhood(),
                updatedAddress.getAddress());
    }

    @DeleteMapping("/{id}")
    public void deleteAddress (@Positive @PathVariable Long id) {

        addressService.deleteById(id);
    }
}