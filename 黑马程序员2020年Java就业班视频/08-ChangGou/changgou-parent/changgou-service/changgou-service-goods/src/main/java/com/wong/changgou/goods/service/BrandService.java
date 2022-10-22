package com.wong.changgou.goods.service;

import com.github.pagehelper.Page;
import com.wong.changgou.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有品牌
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     */
    Brand findById(Integer id);

    /***
     * 新增品牌
     */
    void add(Brand brand);

    /***
     * 修改品牌数据
     */
    void update(Brand brand);

    /***
     * 删除品牌
     */
    void delete(Integer id);

    /***
     * 根据查询条件查询品牌，结果分页
     */
    Page<Brand> searchPage(Map<String, String> searchMap, int pageNo, int pageSize);
}
