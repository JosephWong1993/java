package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.PermissionDao;
import com.wong.dao.RoleDao;
import com.wong.dao.UserDao;
import com.wong.pojo.Permission;
import com.wong.pojo.Role;
import com.wong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 用户服务
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 根据用户名查询数据库中的用户信息，还需要查询用户关联的角色以及
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            //根据用户id查询对应的角色
            Set<Role> roles = roleDao.findByUserId(user.getId());
            //遍历校色，查询对应的权限
            if (roles != null && roles.size() > 0) {
                for (Role role : roles) {
                    //根据角色id查询对应的权限
                    Set<Permission> permissions = permissionDao.findByRoleId(role.getId());
                    role.setPermissions(permissions);
                }
            }
            user.setRoles(roles);
        }

        return user;
    }
}
