package com.practical.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // SELECT * FROM address WHERE country = ?
    @Query("SELECT s FROM Address s WHERE s.country = ?1")
    Optional<Address> findAddressByCountry(String country);

}
