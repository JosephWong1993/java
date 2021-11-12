package com.wong.constant;

public class RedisConstant {
    //套餐图片所有图片名称
    public static final String SET_MEAL_PIC_RESOURCES = "setMealPicResources";
    //套餐图片保存在数据库中的图片名称
    public static final String SET_MEAL_PIC_DB_RESOURCES = "setMealPicDbResources";

    public static final String SEND_TYPE_ORDER = "001";//用于缓存体检预约时发送的验证码
    public static final String SEND_TYPE_LOGIN = "002";//用于缓存手机号快速登录时发送的验证码
    public static final String SEND_TYPE_GET_PWD = "003";//用于缓存找回密码时发送的验证码
}