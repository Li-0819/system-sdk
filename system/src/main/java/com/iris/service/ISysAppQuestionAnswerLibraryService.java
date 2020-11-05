package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryEditDTO;
import com.iris.model.dto.system.SysAppQuestionAnswerLibraryListDTO;
import com.iris.model.entity.SysAppQuestionAnswerLibrary;
import com.iris.model.vo.system.SysAppQuestionAnswerLibraryVO;


/**
 * <p>
 * APP答疑资料库 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysAppQuestionAnswerLibraryService extends IService<SysAppQuestionAnswerLibrary> {

    /**
     * 获取APP答疑资料库列表
     * @param sysAppQuestionAnswerLibraryListDTO {@link SysAppQuestionAnswerLibraryListDTO}
     * @return
     */
    PageResponseVO<SysAppQuestionAnswerLibraryVO> getList(SysAppQuestionAnswerLibraryListDTO sysAppQuestionAnswerLibraryListDTO);

    /**
     * 编辑APP答疑资料库
     * @param sysAppQuestionAnswerLibraryEditDTO {@link SysAppQuestionAnswerLibraryEditDTO}
     */
    void edit(SysAppQuestionAnswerLibraryEditDTO sysAppQuestionAnswerLibraryEditDTO);

    /**
     * 获取APP答疑资料库详情
     * @param id APP答疑资料库ID
     * @return
     */
    SysAppQuestionAnswerLibraryVO getDetail(String id);
}
