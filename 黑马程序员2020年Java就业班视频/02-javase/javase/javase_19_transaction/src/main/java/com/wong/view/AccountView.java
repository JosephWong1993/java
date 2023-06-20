package com.wong.view;

import com.wong.service.AccountService;

public class AccountView {
    public static void main(String[] args) {
        String payerName = "tom";
        String payeeName = "jerry";
        double money = 1000;
        new AccountService().transfer(payerName, payeeName, money);
    }
}
