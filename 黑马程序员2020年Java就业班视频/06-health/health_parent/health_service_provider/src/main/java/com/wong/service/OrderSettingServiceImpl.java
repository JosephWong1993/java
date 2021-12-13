package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.OrderSettingDao;
import com.wong.pojo.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    /**
     * 批量导入预约设置信息
     *
     * @param list 预约设置信息列表
     */
    @Override
    public void add(List<OrderSetting> list) {
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                //根据日期查询是否已经进行了预约设置
                long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if (count > 0) {
                    //如果已经进行了设置需要执行更新
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                } else {
                    //如果没有进行设置执行插入操作
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    /**
     * 查询某个月份对应的设置信息
     *
     * @param orderDate yyyy-MM
     * @return 设置信息
     */
    @Override
    public List<Map<String, Integer>> getOrderSettingByMonth(String orderDate) {
        //TODO：日期查询异常
        String begin = orderDate + "-1";
        String end = orderDate + "-31";
        Map<String, String> map = new HashMap<>();
        map.put("dateBegin", begin);
        map.put("dateEnd", end);
        List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(map);
        List<Map<String, Integer>> data = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                Date orderDate2 = orderSetting.getOrderDate();
                int number = orderSetting.getNumber();
                int reservations = orderSetting.getReservations();
                int date = orderDate2.getDate();
                Map<String, Integer> map1 = new HashMap<>();
                map1.put("date", date);
                map1.put("number", number);
                map1.put("reservations", reservations);
                data.add(map1);
            }
        }
        return data;
    }

    /**
     * 根据日期修改可预约人数
     *
     * @param orderSetting
     */
    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        Date orderDate = orderSetting.getOrderDate();
        long count = orderSettingDao.findCountByOrderDate(orderDate);
        if (count > 0) {
            // 已经设置过了，执行更新操作
            orderSettingDao.editNumberByOrderDate(orderSetting);
        } else {
            // 没有进行设置，执行插入操作
            orderSettingDao.add(orderSetting);
        }
    }
}
