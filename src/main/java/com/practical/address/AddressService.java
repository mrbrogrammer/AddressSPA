package com.practical.address;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    public void addNewAddress(Address address) {
        Optional<Address> addressOptional = addressRepository.findAddressByCountry(address.getCountry());

        if (addressOptional.isPresent()) {
            throw new IllegalStateException("Country taken");
        }
        addressRepository.save(address);
    }
}
