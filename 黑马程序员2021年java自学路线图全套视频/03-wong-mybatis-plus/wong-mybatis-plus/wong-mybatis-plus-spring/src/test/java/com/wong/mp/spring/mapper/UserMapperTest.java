package com.wong.mp.spring.mapper;

import com.wong.mp.spring.config.SpringConfig;
import com.wong.mp.spring.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void selectList() {
        List<User> users=userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectOne() {
    }

    @Test
    public void exists() {
    }
}