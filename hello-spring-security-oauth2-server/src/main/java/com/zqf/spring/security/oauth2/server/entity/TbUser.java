package com.zqf.spring.security.oauth2.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 11:30
 * Description:
 *
 * @ Modified By：
 */
@Data
@TableName(value = "tb_user")
public class TbUser implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private Date created;
    private Date updated;
}
