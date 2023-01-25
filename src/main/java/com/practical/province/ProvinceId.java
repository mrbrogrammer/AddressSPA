package com.practical.province;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProvinceId implements Serializable {
    private String countryCode;
    private String provinceCode;

    public ProvinceId(
            String countryCode,
            String provinceCode) {
        this.countryCode = countryCode;
        this.provinceCode = provinceCode;
    }

    public ProvinceId() {
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }
// equals() and hashCode()

}
