package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * <p>
 * 流水号管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSerialNumber对象", description="流水号管理")
public class SysSerialNumber extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "评价ID")
    private String serialType;

    private String prefix;

    private LocalDateTime serialDate;

    private String number;

    @Schema(name = "活动行为类型(点赞/踩踏)")
    private String remark;
}
