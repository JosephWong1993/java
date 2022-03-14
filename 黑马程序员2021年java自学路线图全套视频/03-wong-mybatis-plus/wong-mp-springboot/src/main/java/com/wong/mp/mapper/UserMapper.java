package com.wong.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wong.mp.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}