package com.changgou.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security 核心配置文件
 * 校验 消费方(用户)信息
 * 对消费者(用户)请求 判断 有些请求是放行的 有些请求是必须拦截的
 *
 */
@Configuration
@EnableWebSecurity
@Order(-1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  设置不需要拦截的请求
     *  包含静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/oauth/login",
                "/oauth/logout",
                "/user/login",
                "/user/logout",
                "/oauth/interface/login",
                "/oauth/toLogin",
                "/login.html",
                "/css/**",
                "/data/**",
                "/fonts/**",
                "/img/**",
                "/js/**"
//                "/oauth/check_token"
        );
    }

    /***
     * 创建授权管理认证对象
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /***
     * 采用BCryptPasswordEncoder对密码进行编码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置必须拦截的请求
     * 配置登录表单
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()        //启用Http基本身份验证
                .and()
                .formLogin()       //启用表单身份验证
                .and()
                .authorizeRequests()    //限制基于Request请求访问
                .anyRequest()
                .authenticated();       //其他请求都需要经过验证

        //配置springSecurity要跳转登录页面的访问路径
       // http.formLogin().loginPage("/oauth/toLogin").
                //配置springSecurity执行登录的访问路径
        //        loginProcessingUrl("/oauth/login");
    }

    /**
     * BCrypt算法, 加密密码测试方法
     * @param args
     */
    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("itcast");
        System.out.println(encode);
    }
}
