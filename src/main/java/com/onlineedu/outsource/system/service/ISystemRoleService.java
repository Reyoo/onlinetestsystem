package com.onlineedu.outsource.system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.onlineedu.outsource.system.model.SystemRoleModel;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ISystemRoleService extends IService<SystemRoleModel> {

    /**
     * 后期改成xml  改用 if null 标签形式 简化代码
     * @param userId
     * @return
     */
    List<SystemRoleModel> getRolenameByUserId(String userId)  ;


    SystemRoleModel getRoleByRolename(String rolename) throws Exception;


    List<SystemRoleModel> getRoleByUserName(String username) throws Exception;

}
