package com.iris.model.entity;

import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单功能授权表
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SitemapActionAuthority对象", description="菜单功能授权表")
public class SitemapActionAuthority extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "authorityType", description = "功能权限类型(菜单-sitemap/按钮-action)")
    private String authorityType;

    @Schema(name = "sitemapActionId", description = "授权功能ID")
    private String sitemapActionId;

    @Schema(name = "authorityTargetType", description = "目标权限类型(User/Position/Role)")
    private String authorityTargetType;

    @Schema(name = "授权对象ID", description = "授权对象ID")
    private String targetId;

    @Schema(name = "isAuthorised", description = "是否授权")
    private Integer isAuthorised;
}
