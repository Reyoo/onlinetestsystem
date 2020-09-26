package com.onlineedu.outsource.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.onlineedu.outsource.system.mapper.SystemRoleMapper;
import com.onlineedu.outsource.system.model.SystemRoleModel;
import com.onlineedu.outsource.system.service.ISystemRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemRoleImpl extends ServiceImpl<SystemRoleMapper, SystemRoleModel> implements ISystemRoleService {

    private final SystemRoleMapper systemRoleMapper ;

    @Override
    public List<SystemRoleModel> getRolenameByUserId(String username)   {
        return systemRoleMapper.selectUserByUserId(username);
    }


    @Override
    public SystemRoleModel getRoleByRolename(String rolename)   {
        return systemRoleMapper.selectRoleByRolename(rolename);
    }

    @Override
    public List<SystemRoleModel> getRoleByUserName(String username)  throws Exception{
        return systemRoleMapper.selectRoleByUsername(username);
    }

}

