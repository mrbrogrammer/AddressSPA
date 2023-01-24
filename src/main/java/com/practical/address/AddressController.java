package com.practical.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddress() {
        return addressService.getAddress();
    }

    @PostMapping
    public void registerNewAddress(@RequestBody Address address) {
        addressService.addNewAddress(address);
    }
}

