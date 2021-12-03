package com.wong.jobs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring_jobs.xml");
    }
}