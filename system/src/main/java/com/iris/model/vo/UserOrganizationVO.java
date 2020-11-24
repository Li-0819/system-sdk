package com.iris.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 15:32
 * @Description: UserOrganizationVO
 */
@Data
public class UserOrganizationVO {

    @Schema(description = "机构ID")
    private String id;

    @Schema(description = "机构编码")
    private String code;

    @Schema(description = "机构名称")
    private String name;

    @Schema(description = "机构类型")
    private String orgClass;

    @Schema(description = "机构名称")
    private String orgClassName;

    @Schema(description = "是否是平台")
    private Integer isPlatform;

    @Schema(description = "隶属代运营ID")
    private String belongToOrg;

    @Schema(description = "顶级ID")
    private String topParentId;

    @Schema(description = "父级ID")
    private String parentId;

    @Schema(description = "父级名称")
    private String parentCode;

    @Schema( description  = "是否企业包车")
    private Integer isCharter;

    @Schema( description  = "是否可以提现")
    private Integer withdrawal;

    @Schema( description  = "提现折扣")
    private Integer discount;

    @Schema( description  = "是否可以提现")
    private Integer defaultWithdrawal;

    @Schema( description  = "是否可以提现")
    private Integer defaultDiscount;
}
