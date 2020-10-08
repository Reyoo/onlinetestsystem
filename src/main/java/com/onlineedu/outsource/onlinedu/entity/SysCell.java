package com.onlineedu.outsource.onlinedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 九宫格表
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCell implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "cell_id", type = IdType.AUTO)
    private Long cellId;

    /**
     * 九宫格图标
     */
    private Blob cellPic;

    /**
     * 九宫格名称
     */
    private String cellName;

    /**
     * 创建者
     */
    private String createby;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改者
     */
    private String modifyer;

    /**
     * 修改时间
     */
    private String modifytime;

    /**
     * 排序
     */
    private Integer showOrder;

    /**
     * 是否开启
     */
    private Boolean isopen;


}
