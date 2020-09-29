package com.onlineedu.outsource.system.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author qisun
 * @since s2020年9月26日10:39:10
 */
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_role")
public class SystemUserToRole extends Model<SystemUserToRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer userToRoleId;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * 角色代号
     */
    @TableField("role_id")
    private String roleId;


    @TableField("user_role_status")
    private String userRoleStatus;

    @Override
    protected Serializable pkVal() {
        return this.userToRoleId;
    }
}
