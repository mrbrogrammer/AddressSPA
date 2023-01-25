package com.practical.province;

import jakarta.persistence.*;

@Entity(name = "Province")
@Table(
        name = "province"
)
public class Province {
    @EmbeddedId
    private ProvinceId provinceId;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    public Province(
            ProvinceId provinceId,
            String name) {
        this.provinceId = provinceId;
        this.name = name;
    }

    public Province() {

    }
    public ProvinceId getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(ProvinceId provinceId) {
        this.provinceId = provinceId;
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
                "provinceId=" + provinceId +
                ", name='" + name + '\'' +
                '}';
    }
}
