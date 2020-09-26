package com.onlineedu.outsource.system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.onlineedu.outsource.system.model.SystemRoleToPermission;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface IRoleToPermissionService extends IService<SystemRoleToPermission> {

    List<SystemRoleToPermission> getRolePermissionByroleID(String roleId) throws Exception;
}
