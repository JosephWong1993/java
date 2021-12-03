package com.wong.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用于对页面提交的表单所对应的实体对象
 * <p>
 * entity ----> 网页中表单提交的数据，所对应的JavaBean对象
 * pojo   ----> 对应数据库表的实体类 JavaBean对象
 */
@Data
public class QueryVO implements Serializable {
    private User user;
    
    private List<User> userList;
    
    private Map<String, User> userMap;
}