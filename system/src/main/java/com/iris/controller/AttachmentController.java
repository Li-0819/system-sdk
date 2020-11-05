package com.iris.controller;

import com.iris.model.dto.CommonFileUploadDTO;
import com.iris.model.vo.AttachmentInfoVO;
import com.iris.service.AttachmentService;
import com.iris.utils.response.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 17:17
 * @Description: AttachUploadController
 */
@Tag(name = "Attachment", description = "全局附件上传统一方法")
@RestController
@RequestMapping("/common/attachment")
public class AttachmentController {

    @Resource private AttachmentService attachmentService;

    @Operation(summary = "通用文件上传(多) - izanagi", tags = "Attachment")
    @PostMapping(path = "/commonFileUpload",headers="content-type=multipart/form-data")
    public ResponseVO<List<AttachmentInfoVO>> commonFileUpload(@RequestPart("files") List<MultipartFile> multipartFiles, @Valid CommonFileUploadDTO dto) {

        List<AttachmentInfoVO> attachmentInfoVOS = attachmentService.commonFileUpload(
                multipartFiles, dto.getAttachType(), dto.getExtraInfo(), dto.getAttachName());

        return ResponseVO.ok(attachmentInfoVOS);
    }
}
