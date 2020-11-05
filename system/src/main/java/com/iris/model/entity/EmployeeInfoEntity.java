package com.iris.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * @author WindChaser
 * @createTime 2020-09-28 9:36
 * @description EmployeeInfoEntity
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="EmployeeInfo对象", description="员工信息")
@TableName(value = "employee_info")
public class EmployeeInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "员工名称")
    private String employeeName;

    @Schema(description = "员工编码")
    private String employeeCode;

    @Schema(description = "员工类型(营养师/临床医师/健康管理师)")
    private String employeeClass;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "出生日期")
    private LocalDate employeeBirth;

    @Schema(description = "证件号")
    private String certificateNumber;

    @Schema(description = "手机号码")
    private String mobileNumber;

    @Schema(description = "openid")
    private String openId;

    @Schema(description = "微信关联ID")
    private String unionId;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "员工状态")
    private String employeeStatus;

    @Schema(description = "是否认证")
    private Integer isAuth;

    @Schema(description = "工作简述")
    private String jobContent;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "总余额(单位是分)")
    private Integer totalBalance;

    @Schema(description = "冻结余额(单位是分)")
    private Integer freezeBalance;

    @Schema(name = "isDefault", description = "是否默认")
    private Integer isDefault;
}
