package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 后台系统操作记录
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysOperationLog对象", description="后台系统操作记录")
public class SysOperationLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "操作标题")
    private String operationTitle;

    @Schema(description = "修改类型(新增/修改/删除)")
    private String operationType;

    @Schema(description = "请求IP(使用者IP)")
    private String requestIp;

    @Schema(description = "主域名")
    private String domain;

    @Schema(description = "请求路由")
    private String requestUri;

    @Schema(description = "请求方法")
    private String requestMethod;

    @Schema(description = "请求参数")
    private String requestParams;

    @Schema(description = "执行时间(单位毫秒)")
    private Integer executionTime;

    @Schema(description = "备注")
    private String remark;
}
