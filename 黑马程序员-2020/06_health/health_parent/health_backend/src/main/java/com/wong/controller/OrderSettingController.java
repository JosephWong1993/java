package com.wong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wong.constant.MessageConstant;
import com.wong.entity.Result;
import com.wong.pojo.OrderSetting;
import com.wong.service.OrderSettingService;
import com.wong.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 预约设置操作
 */
@RestController
@RequestMapping("/order_setting")
public class OrderSettingController {
    @Reference
    private OrderSettingService orderSettingService;

    @RequestMapping("upload")
    public Result upload(MultipartFile excelFile) {
        try {
            List<String[]> data = POIUtils.readExcel(excelFile);
            if (data.size() > 0) {
                List<OrderSetting> list = new ArrayList<>();
                for (String[] rowData : data) {
                    String date = rowData[0];
                    String number = rowData[1];
                    OrderSetting orderSetting = new OrderSetting(new Date(date),
                            Integer.parseInt(number));
                    list.add(orderSetting);
                }
                orderSettingService.add(list);
            }
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
        return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
    }
}