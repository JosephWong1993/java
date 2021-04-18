package com.wong.factory;

import com.wong.service.AccountService;
import com.wong.utils.TransactionManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 基于CgLib的动态代理（第三方jar包）
 * 作用：用于创建AccountService动态代理对象的工厂类
 */
@Component
public class CglibAccountServiceFactory {
    //指定被代理对象（AccountServiceImpl对象）
    @Autowired
    @Qualifier("accountServiceImpl")
    private AccountService accountService;
    
    @Autowired
    private TransactionManager transactionManager;
    
    /**
     * 用于创建AccountService的动态代理对象
     */
    @Bean("cgLibAccountService")
    public AccountService createAccountServiceProxy() {
        //创建AccountService的动态代理对象
        AccountService cgLibAccountService = (AccountService) Enhancer
                .create(accountService.getClass(), new MethodInterceptor() {
                    
                    /**
                     * intercepet 方法
                     * @param o 就是创建出来的动态代理对象的引用
                     * @param method 被代理对象 所要增强的方法
                     * @param objects 被代理对象 所要执行的方法 所接收的实际参数值
                     * @param methodProxy 所要执行方法的代理对象 method.invoke()
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                            throws Throwable {
                        System.out.println("被代理对象 = " + accountService);
                        /*System.out.println("o = " + o);*/ //造成递归？？？
                        System.out.println("被增强的方法 = " + method.getName());
                        System.out.println("被增强的方法 所接收的实际参数值 = " + Arrays.toString(objects));
                        
                        Object rtValue = null;
                        try {
                            //开启事务（增强）
                            transactionManager.begin();
                            
                            //调用 被代理对象 的原有方法
                            rtValue = method.invoke(accountService, objects);
                            
                            //提交事务（增强）
                            transactionManager.commit();
                        } catch (Exception e) {
                            //回滚事务（增强）
                            e.printStackTrace();
                            transactionManager.rollback();
                        } finally {
                            //释放连接（增强）
                            transactionManager.close();
                        }
                        return rtValue;
                    }
                });
        return cgLibAccountService;
    }
}
