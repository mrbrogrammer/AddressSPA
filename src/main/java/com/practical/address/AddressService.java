package com.practical.address;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
