package com.wong.pool03;

import java.util.concurrent.Callable;

public class QieGeCallable implements Callable<String[]> {
    @Override
    public String[] call() throws Exception {
        String str = "aa bbb    ccc ddd eee    f";
        return str.split(" +");
    }
}
