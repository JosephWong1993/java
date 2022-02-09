package com.wong.service;

import com.wong.constant.MessageConstant;
import com.wong.dao.MemberDao;
import com.wong.dao.OrderDao;
import com.wong.dao.OrderSettingDao;
import com.wong.entity.Result;
import com.wong.pojo.Member;
import com.wong.pojo.Order;
import com.wong.pojo.OrderSetting;
import com.wong.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private OrderDao orderDao;

    //体检预约
    @Override
    public Result order(Map<String, String> map) {
        //检查用户所选择的预约日期是否已经提前进行了预约设置，如果没有设置则无法进行预约
        String orderDateStr = map.get("orderDate");

        Date orderDate;
        try {
            orderDate = DateUtils.parseString2Date(orderDateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ORDER_FAIL);
        }

        OrderSetting orderSetting = orderSettingDao.findByOrderDate(orderDate);
        if (orderSetting == null) {
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }

        //检查预约日期是否预约已满
        int number = orderSetting.getNumber();//可预约人数
        int reservations = orderSetting.getReservations();//已预约人数
        if (reservations >= number) {
            //预约已满，不能预约
            return new Result(false, MessageConstant.ORDER_FULL);
        }

        //检查当前用户是否为会员，根据手机号判断
        String telephone = map.get("telephone");
        Member member = memberDao.findByTelephone(telephone);
        if (member == null) {
            //不是会员，自动注册
            member = new Member();
            member.setName(map.get("name"));
            member.setPhoneNumber(telephone);
            member.setIdCard(map.get("idCard"));
            member.setSex(map.get("sex"));
            member.setRegTime(new Date());
            memberDao.add(member);
        } else {
            //检查用户是否重复预约（同一个用户在同一天预约了同一个套餐），如果是重复预约则无法完成再次预约
            Integer memberId = member.getId();
            int setMealId = Integer.parseInt(map.get("setmealId"));
            Order order = new Order();
            order.setMemberId(memberId);
            order.setOrderDate(orderDate);
            order.setSetmealId(setMealId);
            List<Order> list = orderDao.findByCondition(order);
            if (list != null && list.size() > 0) {
                //重复预约
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        }

        //更新已预约人数
        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingDao.editReservationsByOrderDate(orderSetting);
        //保存预约信息
        Order order = new Order(member.getId(),
                orderDate,
                map.get("orderType"),
                Order.ORDERSTATUS_NO,
                Integer.parseInt(map.get("setmealId")));
        orderDao.add(order);

        return new Result(true, MessageConstant.ORDER_SUCCESS, order.getId());
    }

    @Override
    public Map findById(Integer id) {
        return orderDao.findById4Detail(id);
    }
}
