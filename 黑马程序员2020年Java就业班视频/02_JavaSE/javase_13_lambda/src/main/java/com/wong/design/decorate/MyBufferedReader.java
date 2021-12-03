package com.wong.design.decorate;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 自定义的装饰类
 * 装饰的是原始流 FileReader
 */
public class MyBufferedReader extends Reader {
    //定义被装饰对象
    //FileReader 读取字符read() 数组read(char[] ch)
    private FileReader r;
    
    public MyBufferedReader(FileReader r) {
        this.r = r;
    }
    
    //创建方法实现读取文本一行
    //实现读取一行，返回字符串，不会返回换行符号
    public String readLine() throws IOException {
        StringBuilder builder = new StringBuilder();
        
        //利用FileReader的方法read读取字符
        int len = 0;
        while ((len = r.read()) != -1) {
            //判断len字符是不是换行符号
            if (len == '\r') {
                //字符不需要，继续读，继续调用read()
                continue;
            }
            if (len == '\n') {
                //一行文本结束，返回缓冲区中的内容
                return builder.toString();
            }
            //字符是有效字符，追加到缓冲区
            builder.append((char) len);
        }
        //返回缓冲区中的字符串
        if(builder.length()>0){
            return builder.toString();
        }
        //while结束，文件没有了
        return null;
    }
    
    
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return r.read(cbuf, off, len);
    }
    
    @Override
    public void close() throws IOException {
        r.close();
    }
}
