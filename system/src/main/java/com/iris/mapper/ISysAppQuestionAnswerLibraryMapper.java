package com.iris.mapper;


import com.iris.model.dto.system.SysAppQuestionAnswerLibraryListDTO;
import com.iris.model.vo.system.SysAppQuestionAnswerLibraryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-30 10:28
 * @description NAME
 */
@Mapper
public interface ISysAppQuestionAnswerLibraryMapper {

    /**
     * 获取APP答疑资料库列表
     * @param sysAppQuestionAnswerLibraryListDTO {@link SysAppQuestionAnswerLibraryListDTO}
     * @return
     */
    List<SysAppQuestionAnswerLibraryVO> getList(@Param("sysAppQuestionAnswerLibraryListDTO") SysAppQuestionAnswerLibraryListDTO sysAppQuestionAnswerLibraryListDTO);

    /**
     * 获取APP答疑资料库详情
     * @param id
     * @return
     */
    SysAppQuestionAnswerLibraryVO getDetail(@Param("id") String id);
}
