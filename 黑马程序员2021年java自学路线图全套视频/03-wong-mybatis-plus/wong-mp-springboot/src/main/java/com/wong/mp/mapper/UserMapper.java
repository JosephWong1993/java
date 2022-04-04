package com.wong.mp.mapper;

import com.wong.mp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    User findById(Long id);
}