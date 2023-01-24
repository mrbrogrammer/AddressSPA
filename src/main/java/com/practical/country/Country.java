package com.practical.country;


import jakarta.persistence.*;

@Entity(name = "Country")
@Table(
        name = "country"
)
public class Country {

    @Id
    @Column(
            name = "countryCode",
            updatable = false
    )
    private String countryCode;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Country(String countryCode,
                   String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public Country() {

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryCode=" + countryCode +
                ", name='" + name + '\'' +
                '}';
    }
}
