package com.onlineedu.outsource.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.onlineedu.outsource.system.model.SystemUserModel;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface IUserService extends IService<SystemUserModel> {



    SystemUserModel updateUser(SystemUserModel user) throws Exception;

    IPage<SystemUserModel> findConditionByPage(Page<SystemUserModel> page, SystemUserModel user) throws Exception;

    SystemUserModel findByUsername(String username) throws Exception;



}
