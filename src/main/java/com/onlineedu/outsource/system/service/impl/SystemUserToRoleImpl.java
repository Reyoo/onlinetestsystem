package com.onlineedu.outsource.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.onlineedu.outsource.system.mapper.SystemUserToRoleMapper;
import com.onlineedu.outsource.system.model.SystemUserToRole;
import com.onlineedu.outsource.system.service.ISystemUserToRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemUserToRoleImpl extends ServiceImpl<SystemUserToRoleMapper, SystemUserToRole> implements ISystemUserToRoleService {


    private final SystemUserToRoleMapper userToRoleMapper ;

    @Override
    public List<SystemUserToRole> getUserRoleByuserID(String userId) throws Exception{
        return userToRoleMapper.selectUserByUserid(userId);
    }
}
