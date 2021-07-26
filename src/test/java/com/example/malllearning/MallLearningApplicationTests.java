package com.example.malllearning;

import com.example.malllearning.mbg.model.PmsBrand;
import com.example.malllearning.service.PmsBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallLearningApplicationTests {
    @Autowired
    private PmsBrandService pmsBrandService;


    @Test
    void contextLoads() {
        List<PmsBrand> pmsBrands = pmsBrandService.listAllBrand();
        System.out.println(pmsBrands);
    }

}
