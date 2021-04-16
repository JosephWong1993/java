package com.wong.stream;

import java.util.stream.Stream;

/**
 * Stream接口方法count()
 * 返回long，返回Stream对象中的个数
 * <p>
 * 此流终结，使用完毕，不能再继续使用Stream对象的方法
 * foreach() 终结此流
 */
public class StreamDemo07 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e");
        long count = stream.count();
        System.out.println(count);
    }
}
