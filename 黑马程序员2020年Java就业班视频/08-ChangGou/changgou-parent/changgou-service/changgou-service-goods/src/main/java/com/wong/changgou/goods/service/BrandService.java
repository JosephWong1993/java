package com.wong.changgou.goods.service;

import com.wong.changgou.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     */
    Brand findById(Integer id);
}
