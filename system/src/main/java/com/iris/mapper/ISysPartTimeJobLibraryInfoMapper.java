package com.iris.mapper;

import com.iris.model.dto.system.SysPartTimeJobLibraryInfoListDTO;
import com.iris.model.vo.system.SysPartTimeJobLibraryInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-04 15:05
 * @description:
 */

@Mapper
public interface ISysPartTimeJobLibraryInfoMapper {

    /**
     * 获取职位素材信息列表
     * @param listDTO {@link SysPartTimeJobLibraryInfoListDTO}
     * @return
     */
    List<SysPartTimeJobLibraryInfoVO> getList(@Param("listDTO") SysPartTimeJobLibraryInfoListDTO listDTO);

    /**
     * 获取职位素材信息详情
     * @param id 职位素材库ID
     * @return
     */
    SysPartTimeJobLibraryInfoVO getDetail(@Param("id")String id);
}
