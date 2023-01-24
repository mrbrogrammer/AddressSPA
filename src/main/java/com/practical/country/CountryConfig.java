package com.practical.country;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CountryConfig {
    @Bean
    CommandLineRunner CountryCommandLineRunner(CountryRepository countryRepository) {

        return args -> {

            Country ZA = new Country(
                    "ZA",
                    "South Africa"
            );
            Country AF = new Country(
                    "AF",
                    "Afghanistan"
            );
            Country AU = new Country(
                    "AU",
                    "Australia"
            );

            countryRepository.saveAll(
                    List.of(
                            ZA,
                            AF,
                            AU
                    )
            );
        };
    }
}
