package com.onlineedu.outsource.system.service;



import com.baomidou.mybatisplus.extension.service.IService;

import com.onlineedu.outsource.system.model.SystemUserModel;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qisun
 * @since qisun
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ISystemUserService extends IService<SystemUserModel> {

//    /**
//     * 根据用户名查询用户
//     * @param username 用户名
//     * @return 用户
//     */
    SystemUserModel getUserByUserName(String username) ;
//
//    User getUserByMobile(String mobile);

    /**
     * 注册用户
     * @param user
     * @return
     */
    SystemUserModel register(SystemUserModel user) throws Exception;


    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    int selectByName(String username) throws Exception;


}
