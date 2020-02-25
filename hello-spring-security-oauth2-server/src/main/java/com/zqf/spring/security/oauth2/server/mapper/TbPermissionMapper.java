package com.zqf.spring.security.oauth2.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqf.spring.security.oauth2.server.entity.TbPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 13:37
 * Description:
 *
 * @ Modified By：
 */
@Mapper
public interface TbPermissionMapper extends BaseMapper<TbPermission> {
    /**
     * 查询权限
     * @param id
     * @return
     */
    List<TbPermission> selectByUserId(@Param("id") Long id);
}
