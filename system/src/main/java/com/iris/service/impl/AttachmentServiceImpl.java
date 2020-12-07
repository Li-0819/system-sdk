package com.iris.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iris.mapper.CommonAttachmentMapper;
import com.iris.model.entity.SysAttachInfo;
import com.iris.model.mapper.SystemAttachInfoMapper;
import com.iris.model.vo.AttachmentInfoVO;
import com.iris.model.vo.system.SysAttachInfoVO;
import com.iris.service.AttachmentService;
import com.iris.utils.attach.AttachmentUpload;
import com.iris.utils.attach.AttachmentUtil;
import com.iris.utils.attach.oss.OSSUtil;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 17:15
 * @Description: impl
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<SystemAttachInfoMapper, SysAttachInfo> implements AttachmentService {

    @Resource private AttachmentUpload attachmentUpload;
    @Resource private CommonAttachmentMapper commonAttachmentMapper;
    @Resource private AttachmentUtil attachmentUtil;
    @Resource private OSSUtil ossUtil;
    @Resource private SystemAttachInfoMapper systemAttachInfoMapper;

    @Override
    public List<AttachmentInfoVO> commonFileUpload(
            List<MultipartFile> multipartFiles, String attachType, String extraInfo, String attachName) {

        JudgeParam.paramIsNotNull(attachType, SystemMsgConstants.ATTACHMENT_TYPE_NOT_FOUND);

        JudgeParam.listSizeMoreThan0(multipartFiles, SystemMsgConstants.ATTACH_INFO_NOT_FOUND);

        List<AttachmentInfoVO> result = new ArrayList<>(0);

        if (!multipartFiles.isEmpty()) {

            AttachmentInfoVO attachmentInfo;
            String targetName, folder, sourceName, fileName, suffix, out;
            JSONObject jsonAttachInfo;
            SysAttachInfo attachInfo;

            for (MultipartFile multipartFile : multipartFiles) {

                //附件解析
                attachmentInfo = attachmentUpload.attachBaseInfo(multipartFile, attachType);
                //上传后的附件名
                targetName = attachmentInfo.getTargetName();
                //附件原名
                sourceName = attachmentInfo.getSourceName();
                //文件原名（不含格式）
                fileName = !JudgeParam.isNullOrUndefined(attachName) ? attachName :
                        sourceName.substring(0, sourceName.lastIndexOf("."));
                //文件格式
                suffix = sourceName.substring(sourceName.lastIndexOf("."));

                jsonAttachInfo = new JSONObject(6);

                jsonAttachInfo.put(SystemCommonField.ATTACHTYPE, attachType);
                jsonAttachInfo.put(SystemCommonField.ATTACHNAME, fileName);
                jsonAttachInfo.put(SystemCommonField.PATH, attachmentInfo.getHalfDir());
                jsonAttachInfo.put(SystemCommonField.EXTENSION, suffix);
                jsonAttachInfo.put(SystemCommonField.EXTRAINFO, extraInfo);
                jsonAttachInfo.put(SystemCommonField.SEQUENCE, multipartFiles.indexOf(multipartFile));

                attachInfo = JSONObject.parseObject(jsonAttachInfo.toJSONString(), SysAttachInfo.class);

                //如果上传到OSS
                if (attachmentUpload.isOss()) {

                    folder = attachmentInfo.getFolder();

                    ossUtil.uploadFileFile(multipartFile, folder, targetName);

                    //视频文件转码
                    if ("".equals(attachType)) {

                        out = attachmentUtil.transcoding(folder, targetName, suffix);

                        if (!JudgeParam.isNullOrUndefined(out)) {
                            //返回的路径开头不带 "/"
                            attachInfo.setTransformPath(File.separator + out);
                        }
                    }
                } else {

                    folder = attachmentUpload.getServerDir() + File.separator + attachmentInfo.getFolder();

                    attachmentUtil.locationUpload(folder, targetName, multipartFile);
                }

                //保存到数据库
                commonAttachmentMapper.insert(attachInfo);

                attachmentInfo.setId(attachInfo.getId());

                result.add(attachmentInfo);
            }
        }

        return result;
    }

    @Override
    public void updateRefIdForAttaches(String refId, List<String> attachmentIds) {

        JudgeParam.paramIsNotNull(refId, SystemMsgConstants.ATTACHMENT_REF_ID_NOT_FOUND);

        if (attachmentIds != null && attachmentIds.size() >= 1) {

            UpdateWrapper<SysAttachInfo> sqlWrapper = new UpdateWrapper<>();

            sqlWrapper.in(SystemCommonField.ID, attachmentIds);

            SysAttachInfo attachInfo = new SysAttachInfo();
            attachInfo.setRefId(refId);
            baseMapper.update(attachInfo, sqlWrapper);
        }
    }

    /**
     * 根据关联ID获取关联附件列表
     * @param refId 关联ID
     */
    @Override
    public List<SysAttachInfoVO> getAttachesByRefId(String refId) {

        JudgeParam.paramIsNotNull(refId, SystemMsgConstants.ATTACHMENT_REF_ID_NOT_FOUND);

        return commonAttachmentMapper.getAttachesByRefId(refId);
    }

    /**
     * 根据关联ID删除关联附件
     * @param refId 关联ID
     */
    @Override
    public void removeAttachesByRefId(String refId, List<String> attachmentIds) {

        JudgeParam.paramIsNotNull(refId, SystemMsgConstants.ATTACHMENT_REF_ID_NOT_FOUND);

        if (attachmentIds != null && attachmentIds.size() >= 1) {

            QueryWrapper<SysAttachInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SystemCommonField.REF_ID, refId);
            queryWrapper.in(SystemCommonField.ID, attachmentIds);

            systemAttachInfoMapper.delete(queryWrapper);
        }
    }
}
