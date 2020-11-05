package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.entity.SysAttachInfo;
import com.iris.model.vo.AttachmentInfoVO;
import com.iris.model.vo.system.SysAttachInfoVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 17:21
 * @Description: AttachmentService
 */
public interface AttachmentService extends IService<SysAttachInfo> {


    /**
     * 通用附件上传接口
     * @param multipartFiles 源附件（必传）
     * @param attachType 附件类型 （必传）
     * @param extraInfo 文件附件信息
     * @return {@link AttachmentInfoVO}
     */
    List<AttachmentInfoVO> commonFileUpload(
            List<MultipartFile> multipartFiles,
            String attachType,
            String extraInfo,
            String attachName
    );

    /**
     * 关联附件
     * @param refId 关联ID
     * @param attachmentIds 被关联的附件
     */
    void updateRefIdForAttaches(String refId, List<String> attachmentIds);

    /**
     * 根据主ID获取关联附件列表
     * @param refId 关联ID
     * @return
     */
    List<SysAttachInfoVO> getAttachesByRefId(String refId);

    /**
     * 根据主ID删除关联附件列表
     * @param refId 关联ID
     * @param attachmentIds 被关联的附件
     * @return
     */
    void removeAttachesByRefId(String refId, List<String> attachmentIds);
}
