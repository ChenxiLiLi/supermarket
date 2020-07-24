package com.tengke.supermarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Mr.Chen
 * @Description: 安全配置类
 * @Date:Created in 23:18 2020/5/2
 */

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 安全过滤器
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行所有权限，并关闭默认的csrf认证
        http.
            authorizeRequests().antMatchers("/**").permitAll()
            .and().csrf().disable();
    }

    /**
     * 认证管理器,加密需要用到
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Spring security框架给了一个默认账号:user  密码在每次服务启动时在启动页面输出
        //指定的登录的账号密码,指定角色
        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        //这样，页面提交时候，密码以明文的方式进行匹配。
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("cxh").password("cxh").roles("ADMIN");
    }

    /**
     * 核心过滤器
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        //忽略相关的静态资源
        web.ignoring().antMatchers("/index.html", "/static/**");
    }
}
