package com.onlineedu.outsource.system.security;


import com.onlineedu.outsource.system.model.SystemPermissionModel;
import com.onlineedu.outsource.system.service.ISystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 配置路径访问限制,若你的用户角色比较简单,不需要存数据库,
 * 可以在ApplicationConfigurerAdapter里配置如
 * httpSecurity
 * .authorizeRequests()
 * .antMatchers("/order").....
 *
 * @author qisun
 * @date 2020/4/10
 */
@Component("accessDecisionService")
public class AccessDecisionService {


    @Autowired
    ISystemPermissionService iSystemPermissionService;


    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 准入访问设置
     * @param request
     * @param auth
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication auth) {
        List<String> whiteList = new ArrayList();
//        whiteList.add("/login/register");
        whiteList.add("/**");

        for (String url : whiteList) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }
        if (auth instanceof AnonymousAuthenticationToken) {
            return false;
        }
        UserDetails user = (UserDetails) auth.getPrincipal();
        String userName = user.getUsername();
        //根据用户名查出能访问哪些url, urls=findUrlByUserName()
        List<String> urls = queryUrlByUserName(userName);
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数据库查询用户权限
     * @param userName
     * @return
     */
    private List<String> queryUrlByUserName(String userName) {
        try {
            /**
             * 根据用户获取权限entry
             */
            List<SystemPermissionModel> systemPermissionModelList = iSystemPermissionService.getPermissionByUsername(userName);
            /**
             * 重排序获取url
             */
            List<String> urlList = systemPermissionModelList.stream().map(SystemPermissionModel::getPermissionUrl).collect(Collectors.toList());
            return urlList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }
}
