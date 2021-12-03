package com.wong.pool03;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 实现线程池练习
 * 1：开启一个线程，计算高斯算法1+2+3+...+100=5050
 * 2：开启一个线程，切割字符串
 * <p>
 * 线程执行任务，选择使用Callable接口
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        //提交任务，计算高斯
        Future<Integer> sumFuture = es.submit(new GaoSiCallable());
        System.out.println(sumFuture.get());

        //提交任务，计算切割字符串
        Future<String[]> splitFuture = es.submit(new QieGeCallable());
        String[] strs = splitFuture.get();
        for (String s : strs) {
            System.out.println(s);
        }
    }
}
