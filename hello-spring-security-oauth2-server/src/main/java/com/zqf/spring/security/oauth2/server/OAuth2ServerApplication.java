package com.zqf.spring.security.oauth2.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in 2019/11/4 15:30
 * Description:
 *
 * @ Modified By：
 */
@SpringBootApplication
@MapperScan(value = "com.zqf.spring.security.oauth2.server.mapper")
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class,args);
    }
}
