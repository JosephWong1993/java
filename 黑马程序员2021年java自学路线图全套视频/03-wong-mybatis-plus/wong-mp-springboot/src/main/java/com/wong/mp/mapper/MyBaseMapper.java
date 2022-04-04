package com.wong.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wong.mp.pojo.User;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {
    List<User> findAll();
}