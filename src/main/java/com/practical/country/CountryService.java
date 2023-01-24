package com.practical.country;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountry() {
        return countryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
