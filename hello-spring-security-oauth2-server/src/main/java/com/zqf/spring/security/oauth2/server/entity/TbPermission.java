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
 * Date: Created in :  2019/11/5 11:33
 * Description:
 *
 * @ Modified By：
 */
@Data
@TableName(value = "tb_permission")
public class TbPermission implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 父权限
     */

    private Long parentId;

    /**
     * 权限名称
     */
//    @Column(name = "`name`")
    private String name;

    /**
     * 权限英文名称
     */
//    @Column(name = "`enname`")
    private String enname;

    /**
     * 备注
     */
//    @Column(name = "description")
    private String description;

//    @Column(name = "created")
    private Date created;

//    @Column(name = "updated")
    private Date updated;

    private static final long serialVersionUID = 1L;
}
