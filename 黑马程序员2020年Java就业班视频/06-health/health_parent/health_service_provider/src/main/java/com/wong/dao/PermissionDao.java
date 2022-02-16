package com.wong.dao;

import com.wong.pojo.Permission;

import java.util.Set;

public interface PermissionDao {
    Set<Permission> findByRoleId(int roleId);
}
