package com.example.malllearning.controller;

import com.example.malllearning.common.api.CommonPage;
import com.example.malllearning.common.api.CommonResult;
import com.example.malllearning.mbg.model.PmsBrand;
import com.example.malllearning.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理
 * Created by chenhao on 2021/7/16
 */
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    @ApiOperation("获取所有品牌")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());

    }

    @ApiOperation("添加品牌")
    @PostMapping("/cteate")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count=brandService.createBrand(pmsBrand);
        if (count==1){
            commonResult = CommonResult.success(pmsBrand);
            log.debug("createBrand success:{}",pmsBrand);
        }else {
            commonResult=CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @PostMapping("/update/{id}")
    public CommonResult updateBrand(@PathVariable("id")Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int count=brandService.updateBrand(id,pmsBrandDto);
        if (count==1){
            commonResult=CommonResult.success(pmsBrandDto);
            log.debug("updateBrand success:{}",pmsBrandDto);
        }else {
            commonResult=CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}",pmsBrandDto);
        }
        return  commonResult;
    }
    @ApiOperation("删除指定id的品牌")
    @GetMapping("/delete/{id}")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count=brandService.deleteBrand(id);
        if (count==1){
            log.debug("deleteBrand success :id={}",id);
            return CommonResult.success(null);
        }else {
            log.debug("deleteBrand failed :id={}",id);
            return CommonResult.failed("操作失败");
        }

    }

    @ApiOperation("分页查询品牌列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        List<PmsBrand> brandList=brandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }
    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id")Long id){
        return CommonResult.success(brandService.getBrand(id));
    }
}
