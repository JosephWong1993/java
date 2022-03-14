package com.wong.mp.spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wong.mp.spring.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}