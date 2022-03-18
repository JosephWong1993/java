package com.wong.mp.spring.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public void insert() {
        User user = new User();
        user.setEmail("2@wong.com");
        user.setAge(31);
        user.setUserName("caocao1");
        user.setName("曹操1");
        user.setPassword("123456");
        int modifyRowCount = userMapper.insert(user);
        System.out.println("modifyRowCount = " + modifyRowCount);
        //获取自增长后的id值，自增长后的id值会回填到user对象中
        System.out.println(user.getId());
    }

    @Test
    public void selectList() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20); //年龄大于20岁
        Page<User> page = new Page<>(1, 1);
        //根据条件查询数据  `
        IPage<User> iPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数：" + iPage.getTotal());
        System.out.println("数据总页数：" + iPage.getPages());
        System.out.println("当前页数：" + iPage.getCurrent());
        List<User> users = iPage.getRecords();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
}