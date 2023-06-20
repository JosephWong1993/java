package com.wong.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * junit第三方的测试工具
 *
 * @Test 运行方法
 * @Before 在...之前运行
 * @After 在...之后运行
 * <p>
 * IO对象
 * @Before 方法，创建流对象
 * @Test 方法，写文件
 * @After 方法，释放资源
 */
public class JunitDemo02 {
    
    private FileWriter fw;
    
    /*@Test
    public static void show() {
    
    }*/
    
    @Test
    public void test() throws IOException {
        /*System.out.println("测试方法");*/
        fw.write("测试junit");
        fw.flush();
    }
    
    @After
    public void after() throws IOException {
        /*System.out.println("最后执行");*/
        fw.close();
    }
    
    @Before
    public void before() throws IOException {
        /*System.out.println("之前执行");*/
        fw = new FileWriter("H://11.txt");
    }
}
