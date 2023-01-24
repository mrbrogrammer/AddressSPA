package com.practical.address;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;
    private  AutoCloseable autoCloseable;
    private AddressService underTest;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AddressService(addressRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
        underTest.addressRepository.deleteAll();
    }

    @Test
    void ShouldGetAllAddresses() {
        // Act
        underTest.getAddress();
        // Assert
        verify(addressRepository).findAll();
    }

    @Test
    void CanAddNewAddress() {
        // Arrange
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

        // Act
        underTest.addNewAddress(address);

        // Assert
        ArgumentCaptor<Address>  addressArgumentCaptor = ArgumentCaptor.forClass(Address.class);
        verify(addressRepository).save(addressArgumentCaptor.capture());
        Address capturedAddress = addressArgumentCaptor.getValue();
        Assertions.assertEquals(capturedAddress, address);
    }

    @Test
    void CheckIfNewAddressIsTaken() {
        // Arrange
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
        // Assert
        Assertions.assertDoesNotThrow( () -> underTest.addNewAddress(address), "Country taken" );

//        verify(addressRepository, never()).save(any());
    }
}