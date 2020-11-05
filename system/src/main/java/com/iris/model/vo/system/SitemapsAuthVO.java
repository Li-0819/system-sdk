package com.iris.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RubyWong
 * @date 2020/7/21 14:50
 * @description 菜单权限信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SitemapsAuthVO extends SitemapsBaseVO {

    @Schema(name = "meta", description = "菜单扩展属性")
    private SitemapsMetaVO meta;
}
