package com.wong.design.decorate;

/**
 * 装饰者设计模式：
 * 为原有对象增加额外功能
 * 原有对象角色，装饰对象角色
 * <p>
 * 典型应用：IO流
 * 缓冲流 Buffered PrintWriter
 * BufferedReader 读取文本行
 * 自己不能单独使用，依靠原始流 FileReader
 * FileReader 读取方法read() 单个字符，字符数组
 * 装饰BufferedReader，readLine()
 * <p>
 * ObjectOutputStream(new FileOutputStream)
 * <p>
 * 实现思想：
 * 装饰对象，和原有对象，必须实现同样的接口，或者是继承同样的父类
 * 再装饰对象中，依赖原有对象
 * 装饰对象中，增强功能
 */
public class DecorateDemo {

}
