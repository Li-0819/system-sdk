package com.iris.model.dto.organization;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author WindChaser
 * @createTime 2020-08-12 17:57
 * @description NAME
 */
@Data
@Schema(name = "OrganizationExtraInfoEditDTO", description = "机构信息数据源")
public class OrganizationExtraInfoEditDTO {

    @Schema(name = "id", description = "机构信息ID")
    private String id;

    @Schema(name = "parentId", description = "隶属机构ID")
    private String parentId;

    @NotBlank(message = SystemMsgConstants.ORGANIZATION_NAME_NOT_FOUNT)
    @Schema(name = "organizationName", description = "机构名称")
    private String organizationName;

    @Schema(name = "organizationShortName", description = "机构简称")
    private String organizationShortName;

//    @NotBlank(message = MsgConstants.UNIFIED_CREDIT_CODE_NOT_FOUNT)
    @Schema(name = "unifiedCreditCode", description = "统一信用代码")
    private String unifiedCreditCode;

    @Schema(name = "organizationCode", description = "组织机构代码")
    private String organizationCode;

    @NotBlank(message = SystemMsgConstants.ORGANIZATION_TYPE_NOT_FOUNT)
    @Schema(name = "organizationClass", description = "机构类型(自营/医院)")
    private String organizationClass;

    @Schema(name = "organizationLogo", description = "机构Logo")
    private String organizationLogo;

    @NotBlank(message = SystemMsgConstants.ORGANIZATION_SIZE_NOT_FOUNT)
    @Schema(name = "organizationSize", description = "机构规模")
    private String organizationSize;

    @Schema(name = "legalPerson", description = "机构法人")
    private String legalPerson;

    @Schema(name = "gender", description = "性别")
    private String gender;

    @Schema(name = "legalPersonNumber", description = "法人手机号码")
    private String legalPersonNumber;

    @Schema(name = "customerPhone", description = "客服电话")
    private String customerPhone;

    @Schema(name = "establishmentDate", description = "成立时间")
    private LocalDateTime establishmentDate;

    @NotNull(message = SystemMsgConstants.LONGITUDE_AND_LATITUDE_NOT_FOUNT)
    @Schema(name = "longitude", description = "经度")
    private BigDecimal longitude;

    @NotNull(message = SystemMsgConstants.LONGITUDE_AND_LATITUDE_NOT_FOUNT)
    @Schema(name = "latitude", description = "纬度")
    private BigDecimal latitude;

    @NotBlank(message = SystemMsgConstants.REGION_NOT_FOUNT)
    @Schema(name = "region", description = "所在地区")
    private String region;

    @Schema(name = "address", description = "详细地址")
    private String address;

    @Schema(name = "organizationProfile", description = "机构简介")
    private String organizationProfile;

    @Schema(name = "organizationStatus", description = "机构状态")
    private String organizationStatus;

    @Schema(name = "businessScope", description = "经营范围")
    private String businessScope;

    @Schema(name = "belongToOrg", description = "隶属机构ID（代运营）")
    private String belongToOrg;

    @Schema(name = "remark", description = "备注")
    private String remark;

    @Schema( description  = "是否是平台级别")
    private Integer isPlatform;

    @Schema( description  = "是否企业包车")
    private Integer isCharter;

    @Schema( description  = "是否可以提现")
    private Integer withdrawal;

    @Schema( description  = "提现折扣")
    private Integer discount;
}
