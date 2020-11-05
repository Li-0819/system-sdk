package com.iris.mapper;

import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationListDTO;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoClassificationVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: WindChaser
 * @create: 2020-11-05 10:47
 * @description: 签到心情图文素材库分类
 */
@Mapper
public interface ISysSignInMoodLibraryInfoClassificationMapper {

    /**
     * 获取签到心情图文素材库分类列表
     * @param listDTO {@link SysSignInMoodLibraryInfoClassificationListDTO}
     * @return
     */
    List<SysSignInMoodLibraryInfoClassificationVO> getList(@Param("listDTO") SysSignInMoodLibraryInfoClassificationListDTO listDTO);

    /**
     * 获取签到心情图文素材库详情
     * @param id ID
     * @return
     */
    SysSignInMoodLibraryInfoClassificationVO getDetail(@Param("id")String id);
}
