package com.zqf.spring.security.oauth2.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/4 17:06
 * Description:  测试类
 *
 * @ Modified By：
 * @Version: $version$
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OAuth2ServerApplicationTest {

    @Test
    public void testPassworldEncoder(){
        System.out.println(new BCryptPasswordEncoder().encode("dhsahdjshdj"));
    }
}
