package com.wong.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wong.constant.MessageConstant;
import com.wong.constant.RedisConstant;
import com.wong.entity.Result;
import com.wong.utils.SMSUtils;
import com.wong.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 验证码发送
 */
@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 用户在线预约时发送验证码
     *
     * @param telephone 手机号
     */
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        //为用户随机生成一个6位验证码
        String validateCode = ValidateCodeUtils.generateValidateCode(6).toString();
        //调用阿里云短信服务为用户发送验证码
//        try {
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, validateCode);
//        } catch (ClientException e) {
//            e.printStackTrace();
//            //短信发送失败
//            return new Result(false, MessageConstant.SEND_VALIDATE_CODE_FAIL);
//        }
        //将验证码保存到redis中，设置有效期为5分钟
        Jedis jedis = jedisPool.getResource();
        jedis.setex(telephone + RedisConstant.SEND_TYPE_ORDER, 300, validateCode);
        jedis.close();
        return new Result(true, MessageConstant.SEND_VALIDATE_CODE_SUCCESS);
    }

    //手机快速登录时发送手机验证码
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(6);//生成6位数字验证码
//        try {
//            //发送短信
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, code.toString());
//        } catch (ClientException e) {
//            e.printStackTrace();
//            //验证码发送失败
//            return new Result(false, MessageConstant.SEND_VALIDATE_CODE_FAIL);
//        }
        System.out.println("发送的手机验证码为：" + code);
        //将生成的验证码缓存到redis
        Jedis jedis = jedisPool.getResource();
        jedis.setex(telephone + RedisConstant.SEND_TYPE_LOGIN,
                5 * 60,
                code.toString());
        jedis.close();
        //验证码发送成功
        return new Result(true, MessageConstant.SEND_VALIDATE_CODE_SUCCESS);
    }
}