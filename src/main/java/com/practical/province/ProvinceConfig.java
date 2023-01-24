package com.practical.province;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProvinceConfig {
    @Bean
    CommandLineRunner ProvinceCommandLineRunner(ProvinceRepository provinceRepository) {

        return args -> {

            Province L = new Province(
                    "ZA",
                    "L",
                    "Limpopo"
            );
            Province EC = new Province(
                    "ZA",
                    "EC",
                    "Eastern Cape"
            );
            Province NC = new Province(
                    "ZA",
                    "NC",
                    "Northern Cape"
            );
            Province WC = new Province(
                    "ZA",
                    "WC",
                    "Western Cape"
            );
            Province KZN = new Province(
                    "ZA",
                    "KZN",
                    "Kwazulu-Natal"
            );
            Province NW = new Province(
                    "ZA",
                    "NW",
                    "North West"
            );
            Province FS = new Province(
                    "ZA",
                    "FS",
                    "Free State"
            );
            Province GP = new Province(
                    "ZA",
                    "L",
                    "Gauteng"
            );


            provinceRepository.saveAll(
                    List.of(
                            L,
                            EC,
                            NC,
                            WC,
                            KZN,
                            NW,
                            FS,
                            GP
                    )
            );
        };
    }
}