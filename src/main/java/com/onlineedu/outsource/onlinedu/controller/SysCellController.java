package com.onlineedu.outsource.onlinedu.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineedu.outsource.onlinedu.entity.SysCell;
import com.onlineedu.outsource.onlinedu.entity.SysDetail;
import com.onlineedu.outsource.onlinedu.entity.SysPic;
import com.onlineedu.outsource.onlinedu.entity.SysTemplate;
import com.onlineedu.outsource.onlinedu.service.ISysCellService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 九宫格表 前端控制器
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/onlinedu/sys-cell")
public class SysCellController {

    private final ISysCellService iSysCellService;


    @GetMapping("/findAll")
    public List<SysCell> findAll(){


        QueryWrapper queryWrapper =  new QueryWrapper<>();

        queryWrapper.last("limit 0,9");

        List<SysCell> list  =  iSysCellService.list(queryWrapper);

        return list;
    }


    //根据九宫格ID查询对应模板下的详细信息
    @GetMapping("/findByCellId")
    public JSON findByCellId(@RequestParam int cellId){

         JSONArray jsonArray = new JSONArray();

         //查询九宫格ID对应模板信息
        SysTemplate sysTemplate = iSysCellService.findTemByCellId(cellId);

        //查询九宫格对应模板下详情
        List list =iSysCellService.findByCellId(cellId);

        //查询九宫格下的首图和尾图
        SysPic sysPic = iSysCellService.findPicByCellId(cellId);

        jsonArray.set(0,sysTemplate);
        jsonArray.set(1,sysPic);
        jsonArray.set(2,list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","success");
        jsonObject.put("data",jsonArray);

        return jsonObject;
    }





}

