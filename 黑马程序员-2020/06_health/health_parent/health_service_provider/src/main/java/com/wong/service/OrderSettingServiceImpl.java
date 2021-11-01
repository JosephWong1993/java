package com.wong.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wong.dao.OrderSettingDao;
import com.wong.pojo.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
