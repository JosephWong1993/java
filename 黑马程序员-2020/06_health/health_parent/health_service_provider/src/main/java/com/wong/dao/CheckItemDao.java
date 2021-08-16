package com.wong.dao;

import com.github.pagehelper.Page;
import com.wong.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    void edit(CheckItem checkItem);

    Page<CheckItem> selectByCondition(String queryString);

    long findCountByCheckItemId(Integer checkItemId);

    void deleteById(Integer id);

    CheckItem findById(Integer id);

    List<CheckItem> findAll();
}