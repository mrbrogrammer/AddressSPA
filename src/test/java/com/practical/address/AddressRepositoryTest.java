package com.practical.address;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AddressRepositoryTest {
    @Autowired
    AddressRepository underTest;
    @BeforeEach
    void setUp() {
        underTest.findAll();
    }

    @AfterEach
    void TearDown() {
        underTest.deleteAll();
    }

    @Test
    void checkIfAddressByCountryExists() {
        // given
        Address address = new Address(
                1L,
                718444197L,
                631502175L,
                "Marshall Town",
                "Johannesburg",
                "Gauteng",
                2001L,
                "South Africa"
        );

        underTest.save(address);
        // when
        boolean exists = underTest.findAddressByCountry("South Africa").isPresent();
        // then
        Assertions.assertTrue(exists);
    }

    @Test
    void checkIfAddressByCountryDoesNotExist() {
        // given
        String country = "Australia";
        // when
        boolean exists = underTest.findAddressByCountry(country).isPresent();
        // then
        Assertions.assertFalse(exists);
    }
}
