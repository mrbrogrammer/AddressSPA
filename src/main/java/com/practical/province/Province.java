package com.practical.province;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Province")
@Table(
        name = "province"
)
public class Province {

    @Id
    @Column(
            name = "provinceCode",
            updatable = false
    )
    private String ProvinceCode;
    @Column(
            name = "countryCode",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String countryCode;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Province(
            String countryCode,
            String provinceCode,
            String name) {
        this.countryCode = countryCode;
        this.ProvinceCode = provinceCode;
        this.name = name;
    }

    public Province() {

    }

    public String getProvinceCode() {
        return ProvinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        ProvinceCode = provinceCode;
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
        return "Province{" +
                "countryCode='" + countryCode + '\'' +
                ", ProvinceCode='" + ProvinceCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
