package com.onlineedu.outsource.onlinedu.mapper;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onlineedu.outsource.onlinedu.entity.SysCell;
import com.onlineedu.outsource.onlinedu.entity.SysDetail;
import com.onlineedu.outsource.onlinedu.entity.SysPic;
import com.onlineedu.outsource.onlinedu.entity.SysTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 九宫格表 Mapper 接口
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Mapper
public interface SysCellMapper extends BaseMapper<SysCell> {


    @Select("SELECT d.detail_local AS detailLocal, detail_name AS detailName ,detail_icon AS detailIcon ,detail_url AS " +
            "detailUrl FROM sys_detail d LEFT JOIN sys_template_detail td ON d.detail_id = td.detail_id LEFT JOIN " +
            "sys_template t ON td.template_id = t.template_id LEFT JOIN sys_cell_template ct ON t.template_id " +
            "= ct.template_id LEFT JOIN sys_cell c ON ct.cell_id = c.cell_id WHERE c.cell_id = #{cellId}")
    List<SysDetail> findByCellId(int cellId);


    @Select("SELECT t.template_name AS templateName FROM sys_template t LEFT JOIN sys_cell_template ct ON t.template_id = ct.template_id " +
            "LEFT JOIN sys_cell c ON ct.cell_id = c.cell_id WHERE c.cell_id = #{cellId}")
    SysTemplate findTemByCellId(int cellId);


    @Select("SELECT  p.head_pic AS headPic ,tail_picc AS tailPicc  FROM sys_pic p LEFT JOIN sys_cell_pic cp ON " +
            "p.pic_id = cp.pic_id LEFT JOIN sys_cell c ON cp.cell_id = c.cell_id WHERE c.cell_id = #{cellId}")
    SysPic findPicByCellId(int cellId);

}
