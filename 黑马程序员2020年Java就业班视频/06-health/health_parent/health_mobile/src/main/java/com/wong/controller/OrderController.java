package com.wong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.exceptions.ClientException;
import com.wong.constant.MessageConstant;
import com.wong.constant.RedisConstant;
import com.wong.entity.Result;
import com.wong.pojo.Order;
import com.wong.service.OrderService;
import com.wong.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * 体检预约
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/submit")
    public Result submit(@RequestBody Map<String, String> map) {
        String telephone = map.get("telephone");
        String validateCode = map.get("validateCode");
        //从redis中获取保存的验证码
        Jedis jedis = jedisPool.getResource();
        String codeInRedis = jedis.get(telephone + RedisConstant.SEND_TYPE_ORDER);
        if (validateCode == null || !validateCode.equals(codeInRedis)) {
            //验证码校验失败
            return new Result(false, MessageConstant.VALIDATE_CODE_ERROR);
        }
        Result result = null;
        //验证码校验通过
        try {
            map.put("orderType", Order.ORDER_TYPE_WEIXIN);
            result = orderService.order(map);
        } catch (Exception e) {
            e.printStackTrace();
            //预约失败
            result = new Result(false, MessageConstant.ORDER_FAIL);
        }
        if (result.isFlag()) {
            //预约成功,发送短信提示
            String orderDate = map.get("orderDate");
            try {
                SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE, telephone, orderDate);
            } catch (ClientException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Map map = orderService.findById(id);
            //查询预约信息成功
            return new Result(true, MessageConstant.QUERY_ORDER_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            //查询预约信息失败
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }
}
