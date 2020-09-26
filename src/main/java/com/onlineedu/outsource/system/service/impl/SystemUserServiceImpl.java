package com.onlineedu.outsource.system.service.impl;


import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.onlineedu.outsource.system.mapper.SystemUserMapper;
import com.onlineedu.outsource.system.model.SystemRoleModel;
import com.onlineedu.outsource.system.model.SystemUserModel;
import com.onlineedu.outsource.system.model.SystemUserToRole;
import com.onlineedu.outsource.system.service.ISystemRoleService;
import com.onlineedu.outsource.system.service.ISystemUserService;
import com.onlineedu.outsource.system.service.ISystemUserToRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugh123
 * @since 2018-05-03
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUserModel> implements ISystemUserService {


    private final ISystemUserToRoleService userToRoleService;

    private final SystemUserMapper systemUserMapper ;

    private final ISystemRoleService systemRoleService;



    @Override
    public SystemUserModel getUserByUserName(String username)   {
        return systemUserMapper.selectUserByUsername(username);
    }

    /**
     * 设置所有通过注册的用户均为普通用户，用户权限变更需要在管理端进行配置
     * @param user
     * @return`
     */

    @Override
    public SystemUserModel register(SystemUserModel user)  throws Exception{
        user.setStatus(true);
        user.setCreateTime(LocalDateTime.now());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(user.getPassword());
        user.setPassword(encode);
        boolean result = this.save(user);
        /**
         * 新用户赋权限为 ROLE_NORMAL
         */

        /**
         * 1. 先去查询角色表中ROLE_NORMAL 对应的id
         * 2. 拿着 角色id 绑定用户id 插入到库中
         * 3. 拿着 默认模板id=1 绑定用户id
         */

        SystemRoleModel systemRoleModel = systemRoleService.getRoleByRolename("ROLE_NORMAL");

        if (result) {
            SystemUserToRole userToRole  = SystemUserToRole.builder().userId(user.getUserId()).roleId(systemRoleModel.getRoleId()).build();
            userToRoleService.save(userToRole);

        }
        return user;
    }

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    @Override
    public int selectByName(String username) throws Exception {

        int count = systemUserMapper.selectByName(username);
        return count;

    }


}
