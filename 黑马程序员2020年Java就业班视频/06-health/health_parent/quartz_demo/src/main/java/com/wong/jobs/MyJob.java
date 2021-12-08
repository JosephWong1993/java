package com.wong.jobs;

import java.util.Date;

/**
 * 自定义job
 */
public class MyJob {
    public void run() {
        System.out.println("自定义任务执行...." + new Date());
    }
}