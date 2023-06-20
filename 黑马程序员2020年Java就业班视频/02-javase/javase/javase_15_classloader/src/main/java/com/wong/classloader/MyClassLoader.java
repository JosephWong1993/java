package com.wong.classloader;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * JDK加载器
 * <p>
 * String类属于JDK中的核心类库 String.class.getClassLoader() null
 * <p>
 * DNSNameService属于JDK的扩展类库 sun.misc.Launcher$ExtClassLoader@677327b6
 * static class ExtClassLoader extends URLClassLoader
 * <p>
 * MyClassLoader是程序人员自己写的类 sun.misc.Launcher$AppClassLoader@18b4aac2
 * static class AppClassLoader extends URLClassLoader
 */
public class MyClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
        
        ClassLoader classLoader1 = DNSNameService.class.getClassLoader();
        System.out.println(classLoader1);
        
        ClassLoader classLoader2 = MyClassLoader.class.getClassLoader();
        System.out.println(classLoader2);
        System.out.println(classLoader2.getParent());
    }
}