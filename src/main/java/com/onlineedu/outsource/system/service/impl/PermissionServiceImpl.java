package com.onlineedu.outsource.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.onlineedu.outsource.system.mapper.PermissionMapper;
import com.onlineedu.outsource.system.model.SystemPermissionModel;
import com.onlineedu.outsource.system.service.IPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, SystemPermissionModel> implements IPermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    public IPage<SystemPermissionModel> findPermission(Page page, SystemPermissionModel systemPermissionModel) throws Exception {


        QueryWrapper queryWrapper = new QueryWrapper();

        /**
         * 这里systemusermodel 不做空判断 。getusername 空指针  null.getUsername
         */
        if(systemPermissionModel != null){
            if(systemPermissionModel.getPermissionUrl() != null){
                queryWrapper.eq("permission_url",systemPermissionModel.getPermissionUrl());
            }

            if(systemPermissionModel.getPermissionComment() != null){
                queryWrapper.eq("permission_comment",systemPermissionModel.getPermissionComment());
            }
        }
        queryWrapper.orderByDesc("createtime");

        return permissionMapper.selectPage(page,queryWrapper);


    }
    @Override
    public int putPermission(String name, SystemPermissionModel body) throws Exception {
        return 0;
    }
    @Override
    public int dropPermission(String permissionId) throws Exception {
        return permissionMapper.deleteById(permissionId);
    }

    @Override
    public int addPermission(SystemPermissionModel permission) throws Exception {
        return 0;
    }


}
