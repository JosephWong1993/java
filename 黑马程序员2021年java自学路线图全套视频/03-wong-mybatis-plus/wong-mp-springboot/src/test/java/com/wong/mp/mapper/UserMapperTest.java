package com.wong.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wong.mp.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
    public void insert() {
        User user = new User();
        user.setMail("2@wong.com");
        user.setAge(31);
        user.setUserName("caocao1");
        user.setName("曹操1");
        user.setPassword("123456");
        user.setAddress("上海");
        int modifyRowCount = userMapper.insert(user);
        System.out.println("modifyRowCount = " + modifyRowCount);
        //获取自增长后的id值，自增长后的id值会回填到user对象中
        System.out.println(user.getId());
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1L);
        user.setAge(19);
        user.setPassword("666666");
        int modifyRowCount = userMapper.updateById(user);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void deleteById() {
        int modifyRowCount = userMapper.deleteById(9L);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "zhangsan");
        map.put("password", "888888");
        int modifyRowCount = userMapper.deleteByMap(map);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void update() {
        User user = new User();
        user.setAge(20);
        user.setPassword("888888");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "zhangsan");
        int modifyRowCount = userMapper.update(user, wrapper);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void testUpdate() {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 21)
                .set("password", "999999")
                .eq("user_name", "zhangsan");
        wrapper.eq("user_name", "zhangsan");
        int modifyRowCount = userMapper.update(null, wrapper);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void selectList() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}