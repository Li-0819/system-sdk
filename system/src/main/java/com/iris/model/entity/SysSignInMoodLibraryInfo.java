package com.iris.model.entity;


import com.iris.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 签到心情图文素材库
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name="SysSignInMoodLibraryInfo对象", description="签到心情图文素材库")
public class SysSignInMoodLibraryInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(name = "素材名称")
    private String libraryName;

    @Schema(name = "图片")
    private String libraryImg;

    @Schema(name = "内容")
    private String libraryContent;

    @Schema(name = "备注")
    private String remark;
}
