package com.wong.service;


import com.wong.entity.PageResult;
import com.wong.entity.QueryPageBean;
import com.wong.pojo.CheckItem;

public interface CheckItemService {
    public void add(CheckItem checkItem);


    PageResult findPage(QueryPageBean queryPageBean);

    void deleteById(Integer id);
}
