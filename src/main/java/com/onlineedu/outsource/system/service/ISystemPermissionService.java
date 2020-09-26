package com.onlineedu.outsource.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineedu.outsource.system.model.SystemPermissionModel;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ISystemPermissionService extends IService<SystemPermissionModel> {

    /**
     * 根据用户名获取所有的权限url
     * @param username
     * @return
     */
    List<SystemPermissionModel> getPermissionByUsername(String username) throws Exception;

}
