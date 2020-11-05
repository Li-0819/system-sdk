package com.iris.model.vo.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author WindChaser
 * @createTime 2020-07-31 13:31
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(name = "SysOrganizationsVO", description = "组织机构表")
public class OrganizationExtraInfoDetailVO extends OrganizationExtraInfoListVO {

    @Schema(name = "organizationCode", description = "组织机构代码")
    private String organizationCode;

    @Schema(name = "gender", description = "性别")
    private String gender;

    @Schema(name = "genderName", description = "性别名称")
    private String genderName;

    @Schema(name = "customerPhone", description = "客服电话")
    private String customerPhone;

    @Schema(name = "establishmentDate", description = "成立时间")
    private LocalDateTime establishmentDate;

    @Schema(name = "longitude", description = "经度")
    private BigDecimal longitude;

    @Schema(name = "latitude", description = "纬度")
    private BigDecimal latitude;

    @Schema(name = "address", description = "详细地址")
    private String address;

    @Schema(name = "organizationProfile", description = "机构简介")
    private String organizationProfile;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema(name = "unifiedCreditCode", description = "统一信用代码")
    private String unifiedCreditCode;

}
