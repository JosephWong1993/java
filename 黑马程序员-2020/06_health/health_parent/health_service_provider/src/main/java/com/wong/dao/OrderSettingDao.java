package com.wong.dao;

import com.wong.pojo.OrderSetting;

import java.util.Date;

public interface OrderSettingDao {
    void add(OrderSetting orderSetting);

    void editNumberByOrderDate(OrderSetting orderSetting);

    long findCountByOrderDate(Date orderDate);
}
