package com.onlineedu.outsource.onlinedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 九宫格进入后关联头尾图片表
 * </p>
 *
 * @author QiSun
 * @since 2020-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCellPic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 九宫格id
     */
    private Integer cellId;

    /**
     * 图片id
     */
    private Integer picId;


}
