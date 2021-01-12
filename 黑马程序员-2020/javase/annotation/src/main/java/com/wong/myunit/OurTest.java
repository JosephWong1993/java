package com.wong.myunit;

public class OurTest {
    @MyTest
    public void show() {
        System.out.println("show");
    }

    public void show2() {
        System.out.println("show2");
    }

    @MyTest
    public void show3() {
        System.out.println("show3");
    }
}
