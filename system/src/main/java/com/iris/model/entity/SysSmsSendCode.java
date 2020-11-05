package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 验证码管理
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSmsSendCode对象", description="验证码管理")
public class SysSmsSendCode extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "手机号码")
    private String mobileNo;

    @Schema(name = "验证码")
    private String verificationCode;

    @Schema(name = "当天发送次数")
    private Integer sendCount;

    @Schema(name = "总发送次数")
    private Integer totalCount;
}
