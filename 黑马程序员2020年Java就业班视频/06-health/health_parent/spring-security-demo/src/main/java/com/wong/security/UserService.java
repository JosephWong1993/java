package com.wong.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public  Map<String, com.wong.pojo.User> map = new HashMap<>();//模拟数据库中的用户数据

    public void initData(){
        com.wong.pojo.User user1 = new com.wong.pojo.User();
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("admin"));

        com.wong.pojo.User user2 = new com.wong.pojo.User();
        user2.setUsername("xiaoming");
        user2.setPassword(passwordEncoder.encode("1234"));

        map.put(user1.getUsername(),user1);
        map.put(user2.getUsername(),user2);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        initData();

        if (username == null || username.equals("")) {
            return null;
        }
        com.wong.pojo.User user = map.get(username);
        if (user == null) {
            return null;
        }
        String passwordInDb = user.getPassword();

        //后期需要根据数据库中查询出的权限和角色动态授权
        List<GrantedAuthority> list = new ArrayList<>();
        if(username.equals("xiaoming")){
            list.add(new SimpleGrantedAuthority("add"));
        }else {
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return new User(username, passwordInDb, list);
    }
}
