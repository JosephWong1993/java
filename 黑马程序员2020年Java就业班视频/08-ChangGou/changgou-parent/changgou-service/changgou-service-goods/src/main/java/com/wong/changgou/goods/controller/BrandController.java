package com.wong.changgou.goods.controller;

import com.wong.changgou.entity.Result;
import com.wong.changgou.entity.StatusCode;
import com.wong.changgou.goods.service.BrandService;
import com.wong.changgou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    //    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")
    public Result<List<Brand>> findAll() {
        List<Brand> brandList = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询全部品牌成功", brandList);
    }

    /**
     * 根据ID查询品牌数据
     */
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", brand);
    }
}