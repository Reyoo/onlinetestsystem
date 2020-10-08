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
 * 模板表
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 模板ID
     */
    @TableId(value = "template_id", type = IdType.AUTO)
    private Integer templateId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 模板图片
     */
    private Blob templatePic;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 创建人
     */
    private String createby;

    /**
     * 显示顺序
     */
    private Integer showOrder;

    /**
     * 是否启用
     */
    private Boolean isopen;


}
