package com.wong.mapper;

import com.wong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 当前接口的动态代理的实现类，注入Spring的容器
 * @Mapper==@Component==@Service==@Repository==@Controller
 */
@Mapper
public interface UserMapper {
    /**
     * 查询所有
     */
    @Select("SELECT * FROM user;")
    List<User> findAll();
}
