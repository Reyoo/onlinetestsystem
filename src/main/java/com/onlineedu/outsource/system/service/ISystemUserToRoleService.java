package com.onlineedu.outsource.system.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.onlineedu.outsource.system.model.SystemUserToRole;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ISystemUserToRoleService extends IService<SystemUserToRole> {

    List<SystemUserToRole> getUserRoleByuserID(String userId) throws Exception;

}
