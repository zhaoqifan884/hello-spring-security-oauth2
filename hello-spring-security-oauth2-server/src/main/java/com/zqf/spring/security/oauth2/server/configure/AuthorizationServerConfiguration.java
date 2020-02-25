package com.zqf.spring.security.oauth2.server.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/4 16:05
 * Description:  配置认证服务器
 *
 * @ Modified By：
 * @Version: $version$
 */
@Configuration
@EnableAuthorizationServer//开启授权服务
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    @Primary//以本次注册为主     因为oauth2框架不识别url属性  ，所以要重写datasource
    @ConfigurationProperties(prefix = "spring.datasource")//配置文件走 spring.datasource
    public DataSource dataSource(){
        // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
        return DataSourceBuilder.create().build();
    }

    @Bean
    public TokenStore tokenStore(){
        //基于jdbc实现，令牌保存至数据库
        return new JdbcTokenStore(dataSource());
    }

    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息(从数据库读取客户端配置)
        return new JdbcClientDetailsService(dataSource());
    }



    /**
     * 授权配置客户端
     * @param clients
     * @throws Exception
     */
    /*@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //在内存中模拟配置
        clients.inMemory()
                .withClient("client")//客户端id
                .secret(passwordEncoder.encode("secret"))//客户端密码
                .authorizedGrantTypes("authorization_code")//授权码模式
                .scopes("app")//授权范围
                .redirectUris("https://www.baidu.com");//注册回调地址  （异步请求）
    }*/



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //客户端配置（从数据库访问）
        clients.withClientDetails(jdbcClientDetailsService());

    }
}
