package com.practical.address;

import com.practical.province.Province;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Address")
@Table(
        name = "address",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "address_email_unique",
                        columnNames = "email"
                )
        }
)
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long addressId;
    @Column(
            name = "line1",
            nullable = false
    )
    private Long line1;
    @Column(
            name = "line2",
            nullable = false
    )
    private Long line2;
    @Column(
            name = "suburb",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String suburb;
    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String city;
    @Column(
            name = "province",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String province;
    @Column(
            name = "postalCode",
            nullable = false
    )
    private Long postalCode;
    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String country;

    public Address() {
    }
    public Address(
            Long line1,
            Long line2,
            String suburb,
            String city,
            String province,
            Long postalCode,
            String country) {
        this.line1 = line1;
        this.line2 = line2;
        this.suburb = suburb;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(
            Long addressId,
            Long line1,
            Long line2,
            String suburb,
            String city,
            String province,
            Long postalCode,
            String country) {
        this.addressId = addressId;
        this.line1 = line1;
        this.line2 = line2;
        this.suburb = suburb;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getLine1() {
        return line1;
    }

    public void setLine1(Long line1) {
        this.line1 = line1;
    }

    public Long getLine2() {
        return line2;
    }

    public void setLine2(Long line2) {
        this.line2 = line2;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", line1=" + line1 +
                ", line2=" + line2 +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                '}';
    }
}