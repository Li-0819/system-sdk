package com.iris.model.vo.organization;

import com.iris.model.vo.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author WindChaser
 * @createTime 2020-08-12 15:41
 * @description NAME
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizationExtraInfoListVO extends BaseVO {

    @Schema(name = "organizationId", description = "机构ID")
    private String organizationId;

    @Schema(name = "organizationName", description = "机构名称")
    private String organizationName;

    @Schema(name = "organizationShortName", description = "机构简称")
    private String organizationShortName;

    @Schema(name = "organizationClass", description = "机构类型(自营/医院)")
    private String organizationClass;

    @Schema(name = "organizationClassName", description = "机构类型名称")
    private String organizationClassName;

    @Schema(name = "organizationLogo", description = "机构Logo")
    private String organizationLogo;

    @Schema(name = "organizationSize", description = "机构规模")
    private String organizationSize;

    @Schema(name = "organizationSizeName", description = "机构规模名称")
    private String organizationSizeName;

    @Schema(name = "legalPerson", description = "机构法人")
    private String legalPerson;

    @Schema(name = "legalPersonNumber", description = "法人手机号码")
    private String legalPersonNumber;

    @Schema(name = "organizationStatus", description = "机构状态")
    private String organizationStatus;

    @Schema(name = "organizationStatusName", description = "机构状态名称")
    private String organizationStatusName;

    @Schema(name = "region", description = "所在地区")
    private String region;

    @Schema(name = "isPlatform", description = "是否是平台")
    private Integer isPlatform;

    @Schema(name = "businessScope", description = "经营范围")
    private String businessScope;

    @Schema(name = "isEnterpriseAuth", description = "是否认证")
    private Integer isEnterpriseAuth;
}
