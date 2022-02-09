package com.wong.service;

import com.wong.entity.Result;

import java.util.Map;

public interface OrderService {
    Result order(Map<String, String> map);

    Map findById(Integer id);
}
