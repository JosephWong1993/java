package com.wong.pojo;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    
    private String name;
    
    private Double money;
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + ", money=" + money + '}';
    }
}
