package com.wong.changgou.goods.controller;

import com.wong.changgou.entity.Result;
import com.wong.changgou.entity.StatusCode;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
//@ControllerAdvice
public class BaseExceptionHandler {
    //    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandle(Exception e) {
        log.error(Strings.EMPTY, e);
        return new Result(false, StatusCode.ERROR, "系统正忙");
    }
}
