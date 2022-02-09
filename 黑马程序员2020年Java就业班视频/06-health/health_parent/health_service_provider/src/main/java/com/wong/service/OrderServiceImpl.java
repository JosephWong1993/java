package com.wong.service;

import com.wong.dao.OrderSettingDao;
import com.wong.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    //体检预约
    @Override
    public Result order(Map<String, String> map) {
        //检查用户所选择的预约日期是否已经提前进行了预约设置，如果没有设置则无法进行预约
        String orderDate = map.get("orderDate");
        orderSettingDao.fin
        return null;
    }
}
