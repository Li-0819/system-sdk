package com.iris.model.dto.system;

import com.iris.utils.constants.SystemMsgConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-09-18 9:38
 * @description AuthorizationEditDTO
 */
@Data
@Schema(name = "AuthorizationEditDTO", description = "授权信息")
public class AuthorizationEditDTO {

    @NotBlank(message = SystemMsgConstants.TARGET_ID_NOT_FOUNT)
    private String targetId;

    private List<SitemapActionAuthorityEditDTO> sitemapActionAuthorityEditDTOS;
}
