package com.example.malllearning.service;

import com.example.malllearning.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 * Created by chenhao on 2021/7/16
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);

}
