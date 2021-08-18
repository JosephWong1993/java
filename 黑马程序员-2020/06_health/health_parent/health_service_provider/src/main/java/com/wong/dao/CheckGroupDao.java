package com.wong.dao;

import com.github.pagehelper.Page;
import com.wong.pojo.CheckGroup;

import java.util.Map;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(Map map);

    Page<CheckGroup> selectByCondition(String queryString);
}