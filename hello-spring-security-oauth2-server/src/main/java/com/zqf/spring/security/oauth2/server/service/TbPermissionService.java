package com.zqf.spring.security.oauth2.server.service;

import com.zqf.spring.security.oauth2.server.entity.TbPermission;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 14:22
 * Description:
 *
 * @ Modified By：
 */
public interface TbPermissionService {
    /**
     * 查询权限
     * @param id
     * @return
     */
    List<TbPermission> selectByUserId(Long id);
}
