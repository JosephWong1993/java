package com.changgou.goods.controller;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BrandControllerTest {

    @Test
    public void findByCateName() throws UnsupportedEncodingException {
        String result = URLEncoder.encode("中文", "utf-8");
        System.out.println(result);
    }
}