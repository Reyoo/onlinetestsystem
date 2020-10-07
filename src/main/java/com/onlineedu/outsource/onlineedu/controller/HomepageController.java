package com.onlineedu.outsource.onlineedu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.onlineedu.outsource.onlineedu.entity.Homepage;
import com.onlineedu.outsource.onlineedu.service.IHomepageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 首页表 前端控制器
 * </p>
 *
 * @author QiSun
 * @since 2020-10-07
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/onlineedu/homepage")
public class HomepageController {

    private  final IHomepageService iHomepageService;

    @RequestMapping("index")
    public String getHomePage(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("isopen",1);
        queryWrapper.orderByDesc("id");

        List<Homepage> list =  iHomepageService.list(queryWrapper);

        return   JSON.toJSON(list).toString();
    }


}

