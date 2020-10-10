package com.onlineedu.outsource.onlinedu.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.onlineedu.outsource.onlinedu.entity.SysCell;
import com.onlineedu.outsource.onlinedu.entity.SysDetail;
import com.onlineedu.outsource.onlinedu.entity.SysPic;
import com.onlineedu.outsource.onlinedu.entity.SysTemplate;
import com.onlineedu.outsource.onlinedu.mapper.SysCellMapper;
import com.onlineedu.outsource.onlinedu.service.ISysCellService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 九宫格表 服务实现类
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SysCellServiceImpl extends ServiceImpl<SysCellMapper, SysCell> implements ISysCellService {

    private final SysCellMapper sysCellMapper;

    @Override
    public List findByCellId(int cellId) {
        return sysCellMapper.findByCellId(cellId);
    }

    @Override
    public SysTemplate findTemByCellId(int cellId) {
        return sysCellMapper.findTemByCellId(cellId);
    }

    @Override
    public SysPic findPicByCellId(int cellId) {
        SysPic sysPic =sysCellMapper.findPicByCellId(cellId);
        System.out.println(sysPic);
        return sysPic;
    }
}
