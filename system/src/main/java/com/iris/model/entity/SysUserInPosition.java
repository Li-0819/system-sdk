package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户与职位表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysUserInPosition对象", description="用户与职位表")
public class SysUserInPosition extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String positionId;

    private String userId;

}
