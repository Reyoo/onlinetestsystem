package com.onlineedu.outsource.onlinedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 模版关联详细表
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysTemplateDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模版id
     */
    private Integer templateId;

    /**
     * 详情id
     */
    private Integer detailId;


}
