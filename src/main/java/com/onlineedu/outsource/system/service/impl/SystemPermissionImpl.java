package com.onlineedu.outsource.system.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.onlineedu.outsource.system.mapper.SystemPermissionMapper;
import com.onlineedu.outsource.system.model.SystemPermissionModel;
import com.onlineedu.outsource.system.service.ISystemPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description：  权限业务实现类
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SystemPermissionImpl extends ServiceImpl<SystemPermissionMapper, SystemPermissionModel> implements ISystemPermissionService {

    private final SystemPermissionMapper systemPermissionMapper ;

    @Override
    public List<SystemPermissionModel> getPermissionByUsername(String username) throws Exception {
        return systemPermissionMapper.selectUserByUsername(username);
    }
}

