package com.wong.service;

import com.wong.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {
    void add(List<OrderSetting> list);

    /**
     * 查询某个月份对应的设置信息
     *
     * @param orderDate yyyy-MM
     * @return 设置信息
     */
    List<Map<String,Integer>> getOrderSettingByMonth(String orderDate);
}
