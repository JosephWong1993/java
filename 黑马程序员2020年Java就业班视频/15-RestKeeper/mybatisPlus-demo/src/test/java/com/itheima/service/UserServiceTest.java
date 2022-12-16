package com.itheima.service;

import com.itheima.entity.User;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Test
    @Rollback(value = false)
    public void save() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword(Md5Crypt.md5Crypt("123".getBytes()));
        userService.save(user);
    }

    @Test
    public void getById() {
        User user = userService.getById("82663d39679e7477c7ebabf52759a9f4");
        System.out.println(user);
    }
}