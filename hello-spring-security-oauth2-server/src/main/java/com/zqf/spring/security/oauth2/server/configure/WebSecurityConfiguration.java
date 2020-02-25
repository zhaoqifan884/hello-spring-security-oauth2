package com.zqf.spring.security.oauth2.server.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/4 15:37
 * Description:  配置类     服务器安全配置 （认证）   WebSecurityConfigurerAdapter:适配器模式
 *
 * @ Modified By：
 * @Version: $version$
 */
@Configuration
@EnableWebSecurity//开启web安全
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)//所有请求的安全认证（全局方法拦截）
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 密码加密方式（默认）
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 自定义认证授权
     * @return
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }
    /**
     * 认证过程(注册账号)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*//在内存里设置认证
        auth.inMemoryAuthentication()
                .withUser("user")
                //密码必须加密
                .password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin999")).roles("ADMIN");*/

        auth.userDetailsService(userDetailsService());
    }
}
