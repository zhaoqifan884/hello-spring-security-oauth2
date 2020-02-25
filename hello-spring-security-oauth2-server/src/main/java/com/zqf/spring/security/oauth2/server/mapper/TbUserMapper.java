package com.zqf.spring.security.oauth2.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zqf.spring.security.oauth2.server.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 11:49
 * Description:
 *
 * @ Modified By：
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {
}
