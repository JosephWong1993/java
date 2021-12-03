package com.wong.study.lock;

/**
 * 用户dao层
 */
public class UserDao {
    private int score;

    /**
     * 模拟读取数据库里用户积分
     */
    public int getScoreFromDb() {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return score;
    }

    public void updateScore(int score) {
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.score = score;
    }
}
