package com.wong.service;

import com.wong.entity.PageResult;
import com.wong.entity.QueryPageBean;
import com.wong.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {

    void add(Integer[] checkItemIds, CheckGroup checkGroup);

    PageResult findPage(QueryPageBean queryPageBean);

    CheckGroup findById(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
}
