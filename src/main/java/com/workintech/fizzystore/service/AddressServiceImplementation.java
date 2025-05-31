package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Address;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressServiceImplementation implements AddressService{

    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Address with id: " + id + " not found.", HttpStatus.NOT_FOUND));
        return address;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Address with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (address.getTitle() != null) {
            addressToUpdate.setTitle(address.getTitle());
        }
        if (address.getName() != null) {
            addressToUpdate.setName(address.getName());
        }
        if (address.getSurname() != null) {
            addressToUpdate.setSurname(address.getSurname());
        }
        if (address.getPhoneNumber() != null) {
            addressToUpdate.setPhoneNumber(address.getPhoneNumber());
        }
        if (address.getCity() != null) {
            addressToUpdate.setCity(address.getCity());
        }
        if (address.getDistrict() != null) {
            addressToUpdate.setDistrict(address.getDistrict());
        }
        if (address.getNeighborhood() != null) {
            addressToUpdate.setNeighborhood(address.getNeighborhood());
        }
        if (address.getAddress() != null) {
            addressToUpdate.setAddress(address.getAddress());
        }

        return addressRepository.save(addressToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        if(!addressRepository.existsById(id)) {
            throw new FizzyStoreException("Address with id: " + id + " not found.", HttpStatus.NOT_FOUND);
        }
        addressRepository.deleteById(id);
    }
}
