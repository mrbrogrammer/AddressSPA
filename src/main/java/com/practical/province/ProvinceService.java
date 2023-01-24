package com.practical.province;

import org.springframework.stereotype.Service;
import java.util.List;

@Service("ProvinceService")
public class ProvinceService {
    ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<Province> getProvince() {
        return provinceRepository.findAll();
    }
}