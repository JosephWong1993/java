package com.wong.controller;

import com.wong.entity.Result;
import com.wong.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 预约设置操作
 */
@RestController
@RequestMapping("/order_setting")
public class OrderSettingController {
    @RequestMapping("upload")
    public Result upload(MultipartFile excelFile) {
        try {
            List<String[]> data = POIUtils.readExcel(excelFile);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}