package com.onlineedu.outsource.onlineedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author QiSun
 * @since 2020-10-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysCellTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer cellId;

    private Integer templateId;

    /**
     * 创建者
     */
    private String creater;

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


}
