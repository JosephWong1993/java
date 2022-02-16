package com.wong.dao;

import com.wong.pojo.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> findByUserId(int id);
}