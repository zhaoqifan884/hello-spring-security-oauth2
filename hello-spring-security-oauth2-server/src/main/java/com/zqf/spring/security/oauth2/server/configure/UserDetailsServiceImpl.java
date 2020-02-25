package com.zqf.spring.security.oauth2.server.configure;

import com.zqf.spring.security.oauth2.server.entity.TbPermission;
import com.zqf.spring.security.oauth2.server.entity.TbUser;
import com.zqf.spring.security.oauth2.server.service.TbPermissionService;
import com.zqf.spring.security.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 10:46
 * Description:  自定义认证授权实现类
 *
 * @ Modified By：
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //由认证中心传入
        TbUser tbUser = tbUserService.getByUserName(s);
        //授权提供
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();

        //非空才去授权
        if (tbUser != null) {
            //将权限授权到TbPermission
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                //授权信息
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                //添加授权的角色
                grantedAuthorities.add(grantedAuthority);
            });
            return new User(tbUser.getUsername(),tbUser.getPassword(),grantedAuthorities);
        }

        return null;
    }
}
