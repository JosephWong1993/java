package com.wong.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 自定义mybatis拦截器
 */
@Intercepts(
        @Signature(
                method = "query",
                type = Executor.class,
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
)
public class CustomInterceptor implements Interceptor {

    /**
     * 拦截方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("自定义mybatis拦截器拦截前");

        Object proceed = invocation.proceed();

        System.out.println("自定义mybatis拦截器拦截后");
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
