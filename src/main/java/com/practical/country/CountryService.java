package com.practical.country;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountry() {
        return countryRepository.findAll();
    }
}
