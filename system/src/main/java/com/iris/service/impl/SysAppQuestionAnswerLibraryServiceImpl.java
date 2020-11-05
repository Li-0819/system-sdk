package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysAppQuestionAnswerLibraryMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryEditDTO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryListDTO;
import com.iris.model.entity.SysAppQuestionAnswerLibrary;
import com.iris.model.mapper.SysAppQuestionAnswerLibraryMapper;
import com.iris.model.vo.system.SysAppQuestionAnswerLibraryVO;
import com.iris.service.AttachmentService;
import com.iris.service.ISysAppQuestionAnswerLibraryService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * APP答疑资料库 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysAppQuestionAnswerLibraryServiceImpl extends ServiceImpl<SysAppQuestionAnswerLibraryMapper, SysAppQuestionAnswerLibrary> implements ISysAppQuestionAnswerLibraryService {

    @Resource private ISysAppQuestionAnswerLibraryMapper iSysAppQuestionAnswerLibraryMapper;

    @Resource private AttachmentService attachmentService;

    /**
     * 获取APP答疑资料库列表
     * @param sysAppQuestionAnswerLibraryListDTO {@link SysAppQuestionAnswerLibraryListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysAppQuestionAnswerLibraryVO> getList(SysAppQuestionAnswerLibraryListDTO sysAppQuestionAnswerLibraryListDTO) {

        PageHelper.startPage(sysAppQuestionAnswerLibraryListDTO.getCurrentPage(), sysAppQuestionAnswerLibraryListDTO.getPageSize());

        return PageResponseVO.of(iSysAppQuestionAnswerLibraryMapper.getList(sysAppQuestionAnswerLibraryListDTO), SysAppQuestionAnswerLibraryVO.class);
    }

    /**
     * 编辑APP答疑资料库
     * @param sysAppQuestionAnswerLibraryEditDTO {@link SysAppQuestionAnswerLibraryEditDTO}
     */
    @Override
    public void edit(SysAppQuestionAnswerLibraryEditDTO sysAppQuestionAnswerLibraryEditDTO) {

        SysAppQuestionAnswerLibrary sysAppQuestionAnswerLibrary = DataTransferUtil.model(sysAppQuestionAnswerLibraryEditDTO, new SysAppQuestionAnswerLibrary());

        if (JudgeParam.isNullOrUndefined(sysAppQuestionAnswerLibrary.getId())){

            baseMapper.insert(sysAppQuestionAnswerLibrary);
        }else {

            JudgeParam.entityIsNotNull(baseMapper.selectById(sysAppQuestionAnswerLibrary.getId()), SystemMsgConstants.APP_QUESTION_ANSWER_NOT_EXIST);

            baseMapper.updateById(sysAppQuestionAnswerLibrary);

            attachmentService.removeAttachesByRefId(sysAppQuestionAnswerLibrary.getId(), sysAppQuestionAnswerLibraryEditDTO.getAttachIds());
        }

        attachmentService.updateRefIdForAttaches(sysAppQuestionAnswerLibrary.getId(), sysAppQuestionAnswerLibraryEditDTO.getAttachIds());
    }

    /**
     * 获取APP答疑资料库详情
     * @param id APP答疑资料库ID
     * @return
     */
    @Override
    public SysAppQuestionAnswerLibraryVO getDetail(String id) {

        SysAppQuestionAnswerLibraryVO sysAppQuestionAnswerLibraryVO = iSysAppQuestionAnswerLibraryMapper.getDetail(id);

        sysAppQuestionAnswerLibraryVO.setAttachInfoVOS(attachmentService.getAttachesByRefId(id));

        return sysAppQuestionAnswerLibraryVO;
    }
}
