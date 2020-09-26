package com.onlineedu.outsource.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.onlineedu.outsource.system.model.SystemUserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
@Mapper
@Repository
public interface SystemUserMapper extends BaseMapper<SystemUserModel> {

    @Select("SELECT user_id as userId,user_name as username,user_mobile as mobile,user_password as password,user_last_login_time AS lastLoginTime,createTime AS createTime,status AS status FROM sys_user WHERE user_name = #{0}")
    SystemUserModel selectUserByUsername(String username);


    @Select("SELECT COUNT(*) FROM sys_user WHERE user_name = #{username} ")
    int selectByName(String username);

}
