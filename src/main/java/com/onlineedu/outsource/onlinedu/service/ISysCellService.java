package com.onlineedu.outsource.onlinedu.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.onlineedu.outsource.onlinedu.entity.SysCell;
import com.onlineedu.outsource.onlinedu.entity.SysDetail;
import com.onlineedu.outsource.onlinedu.entity.SysPic;
import com.onlineedu.outsource.onlinedu.entity.SysTemplate;

import java.util.List;

/**
 * <p>
 * 九宫格表 服务类
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
public interface ISysCellService extends IService<SysCell> {

    List findByCellId(int cellId);

    SysTemplate findTemByCellId(int cellId);


    SysPic findPicByCellId(int cellId);

}
