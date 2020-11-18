package com.iris.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 机构附属信息
 * </p>
 *
 * @author amaterasu
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema( name = "OrganizationExtraInfo对象", description="机构附属信息")
public class OrganizationExtraInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema( description  = "隶属机构ID")
    private String organizationId;

    @Schema( description  = "隶属代运营机构ID")
    private String belongToOrg;

    @Schema( description  = "机构简称")
    private String organizationShortName;

    @Schema( description  = "机构类型(自营/医院)")
    private String organizationClass;

    @Schema( description  = "统一信用代码")
    private String unifiedCreditCode;

    @Schema( description  = "组织机构代码")
    private String organizationCode;

    @Schema( description  = "机构Logo")
    private String organizationLogo;

    @Schema( description  = "机构规模")
    private String organizationSize;

    @Schema( description  = "机构法人")
    private String legalPerson;

    @Schema( description  = "性别")
    private String gender;

    @Schema( description  = "法人手机号码")
    private String legalPersonNumber;

    @Schema( description  = "机构状态")
    private String organizationStatus;

    @Schema( description  = "客服电话")
    private String customerPhone;

    @Schema( description  = "成立时间")
    private LocalDateTime establishmentDate;

    @Schema( description  = "经度")
    private BigDecimal longitude;

    @Schema( description  = "纬度")
    private BigDecimal latitude;

    @Schema( description  = "所在地区")
    private String region;

    @Schema( description  = "详细地址")
    private String address;

    @Schema( description  = "机构简介")
    private String organizationProfile;

    @Schema( description  = "经营范围")
    private String businessScope;

    @Schema( description  = "是否认证")
    private Integer isEnterpriseAuth;

    @Schema( description  = "是否是平台级别")
    private Integer isPlatform;

    @Schema( description  = "是否企业包车")
    private Integer isCharter;

    @Schema( description  = "是否可以提现")
    private Integer withdrawal;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    @Schema( description  = "提现折扣")
    private Integer discount;

    @Schema( description  = "备注")
    private String remark;

}
