package com.wong.study.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

/**
 * 分布式锁Demo
 */
public class DistributedLockDemo {
    public static void main(String[] args) throws InterruptedException {
        //重试策略  每隔1s重试一次，共重试10次
        RetryPolicy retryPolicy = new RetryNTimes(10, 1000);
        //构造客户端
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);

        //启动
        client.start();

        //构造锁
        InterProcessLock lock = new InterProcessMutex(client, "/lock/user/1/update");

        //构造dao层
        UserDao userDao = new UserDao();

        //100个线程并发执行+1操作
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
//                        lock.acquire();
                        int score = userDao.getScoreFromDb();
                        score++;
                        userDao.updateScore(score);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
//                            lock.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.sleep(5000L);
        System.out.println("完成，结果：" + userDao.getScoreFromDb());
    }
}
