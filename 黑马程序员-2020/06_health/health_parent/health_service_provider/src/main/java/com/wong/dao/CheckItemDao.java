package com.wong.dao;

import com.github.pagehelper.Page;
import com.wong.pojo.CheckItem;

public interface CheckItemDao {
    public void add(CheckItem checkItem);

    Page<CheckItem> selectByCondition(String queryString);

    long findCountByCheckItemId(Integer checkItemId);

    void deleteById(Integer id);
}