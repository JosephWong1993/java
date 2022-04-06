package com.wong.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wong.mp.enums.SexEnum;
import com.wong.mp.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
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
        user.setMail("guanyu@wong.com");
        user.setAge(29);
        user.setUserName("guanyu");
        user.setName("关羽");
//        user.setPassword("123456");
        user.setAddress("上海");
        int modifyRowCount = userMapper.insert(user);
        System.out.println("modifyRowCount = " + modifyRowCount);
        //获取自增长后的id值，自增长后的id值会回填到user对象中
        System.out.println(user.getId());
    }

    @Test
    public void deleteById() {
        int modifyRowCount = userMapper.deleteById(2L);
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
    public void delete() {
//        QueryWrapper<User> wrapper=new QueryWrapper<>();
//        wrapper.eq("user_name","caocao1")
//                .eq("password","123456");

        User user = new User();
        user.setPassword("123456");
        user.setUserName("caocao");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        int modifyRowCount = userMapper.delete(wrapper);
        System.out.println("modifyRowCount = " + modifyRowCount);
    }

    @Test
    public void deleteBatchIds() {
        //根据id集合批量删除
        int modifyRowCount = this.userMapper.deleteBatchIds(Arrays.asList(1L, 10L, 20L));
        System.out.println("modifyRowCount = " + modifyRowCount);
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
        User user = userMapper.selectById(2L);
        System.out.println(user);
    }

    @Test
    public void selectBatchIds() {
        //根据id集合批量查询
        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(2L, 3L, 10L));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "李四");
        //根据条件查询一条数据，如果结果超过一条会报错
        User user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 23); //年龄大于23岁
        // 根据条件查询数据条数
        Long count = this.userMapper.selectCount(wrapper);
        System.out.println("count = " + count);
    }

    @Test
    public void selectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "itcast");
        List<User> userList = userMapper.selectList(wrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void selectBySex() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("sex", SexEnum.WOMAN);
        List<User> users = this.userMapper.selectList(wrapper);
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

    @Test
    public void findById() {
        User user = userMapper.findById(2L);
        System.out.println(user);
    }

    @Test
    public void allEl() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "李四");
        params.put("age", "20");
        params.put("password", null);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.allEq(params);
//        queryWrapper.allEq(params, false);
//        queryWrapper.allEq((k, v) -> (k.equals("age") || k.equals("id")), params);
        queryWrapper.allEq((k, v) -> (k.equals("age") || k.equals("id") || k.equals("name")), params);
        List<User> users = userMapper.selectList(queryWrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void eq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password", "123456")
                .ge("age", 20)
                .in("name", "李四", "王五", "赵六");
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void like() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "曹");
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void orderByDesc() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age");
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void or() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "李四")
                .or().eq("age", 24);
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void select() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "李四")
                .or()
                .eq("age", 24)
                .select("id", "name", "age");
        List<User> users = this.userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void arSelectById() {
        User user = new User();
        user.setId(2L);
        user = user.selectById();
        System.out.println(user);
    }

    @Test
    public void arInsert() {
        User user = new User();
        user.setName("貂蝉");
        user.setPassword("123456");
        user.setAge(20);
        user.setUserName("diaochan");
        user.setMail("diaochan@wong.cn");
        user.setSex(SexEnum.WOMAN);
        boolean result = user.insert();
        System.out.println("result = " + result);
    }

    @Test
    public void arUpdateById() {
        User user = new User();
        user.setId(13L);
        user.setAge(31);
        boolean update = user.updateById();
        System.out.println(update);
    }

    @Test
    public void arDeleteById() {
        User user = new User();
        user.setId(13L);
        boolean delete = user.deleteById();
        System.out.println(delete);
    }

    @Test
    public void arSelectList() {
        User user = new User();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.le("age", "20");
        List<User> users = user.selectList(userQueryWrapper);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void version() {
        User user = new User();
        user.setId(2L);

        User userVersion = user.selectById();

        user.setAge(22);
        user.setVersion(userVersion.getVersion());

        boolean result = user.updateById();
        System.out.println("result = " + result);
    }

    @Test
    public void findAll() {
        List<User> users = this.userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}