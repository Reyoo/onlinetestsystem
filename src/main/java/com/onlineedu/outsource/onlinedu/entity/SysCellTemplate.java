package com.onlineedu.outsource.onlinedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 九宫格模板关联表
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCellTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 模板ID
     */
    private Integer templateId;

    /**
     * 九宫格ID
     */
    private Integer cellId;


}
