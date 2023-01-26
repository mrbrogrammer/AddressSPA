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
                    new ProvinceId("ZA","L"),
                    "Limpopo"
            );
            Province EC = new Province(
                    new ProvinceId("ZA","EC"),
                    "Eastern Cape"
            );
            Province NC = new Province(
                    new ProvinceId("ZA","NC"),
                    "Northern Cape"
            );
            Province WC = new Province(
                    new ProvinceId("ZA","WC"),
                    "Western Cape"
            );
            Province KZN = new Province(
                    new ProvinceId("ZA","KZN"),
                    "Kwazulu-Natal"
            );
            Province NW = new Province(
                    new ProvinceId("ZA","NW"),
                    "North West"
            );
            Province FS = new Province(
                    new ProvinceId("ZA","FS"),
                    "Free State"
            );
            Province GP = new Province(
                    new ProvinceId("ZA","GP"),
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