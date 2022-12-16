package com.itheima.dao;

import com.itheima.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback(value = false)
    public void testInsert() {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        userMapper.insert(user);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById("82663d39679e7477c7ebabf52759a9f4");
        System.out.println(user);
    }
}