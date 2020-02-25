package com.zqf.spring.security.oauth2.server.service.impl;

import com.zqf.spring.security.oauth2.server.entity.TbPermission;
import com.zqf.spring.security.oauth2.server.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 14:34
 * Description:
 *
 * @ Modified By：
 */
@Service
public class TbPermissionServiceImpl implements TbPermissionService {
    @Resource
    private TbPermissionServiceImpl tbPermissionService;


    @Override
    public List<TbPermission> selectByUserId(Long id) {
        return tbPermissionService.selectByUserId(id);
    }
}
