package com.iris.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-03-31 18:56
 * @Description: CommonFileUploadDTO
 */
@Data
@Valid
@Schema(name = "CommonFileUploadDTO", description = "通用附件上传实体")
public class CommonFileUploadDTO {

    @Schema(name = "attachName", description = "附件名称")
    private String attachName;

//    @NotBlank(message = SystemMsgConstants.ATTACHMENT_REF_ID_NOT_FOUND)
    @Schema(name = "refId", description = "关联ID", required = true)
    private String refId;

//    @NotBlank(message = CommonSystemMsgConstants.ATTACHMENT_TYPE_NOT_FOUND)
    @Schema(name = "attachType", description = "附件类型", required = true)
    private String attachType;

    @Schema(name = "extraInfo", description = "附加信息")
    private String extraInfo;

    @Schema(name = "idsToSave", description = "需要保留的文件ID集合")
    private List<String> idsToSave;

    @Schema(name = "appletIdsToSave", description = "需要保留的文件ID集合(小程序端使用)")
    private String appletIdsToSave;

    @Schema(name = "sequence", description = "排序，默认按照上传顺序排序", example = "0")
    private Integer sequence;
}
