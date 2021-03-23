package com.wong.controller;

import com.wong.service.AccountService;
import org.springframework.stereotype.Controller;

/**
 * 账户的控制层
 */
@Controller
public class AccountController {
    //依赖注入AccountService对象
    private AccountService accountService;

}