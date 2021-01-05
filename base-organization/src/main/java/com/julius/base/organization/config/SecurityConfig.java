package com.julius.base.organization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Title: base-architecture
 * @Package com.julius.base.organization.config
 * @Author Julius Zhou
 * @Date 2020-12-30 22:36
 * @Description: 安全配置类
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {






    /**
     * 重写配置方法，主要是忽略一些请求，不走安全验证
     * @param webSecurity
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity webSecurity)throws Exception{
//        webSecurity.ignoring().antMatchers("swagger*");
//        webSecurity.ignoring().antMatchers("/swagger");
        webSecurity.ignoring().antMatchers("swagger-ui.html");
        webSecurity.ignoring().antMatchers("/user");

    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("swagger-ui.html").permitAll()
        .antMatchers("/user").permitAll();
    }

}
