package com.iris.mapper;


import com.iris.model.dto.system.SysSignInMoodLibraryInfoListDTO;
import com.iris.model.entity.SysSignInMoodLibraryInfo;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoDetailVO;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-28 17:54
 * @description NAME
 */
@Mapper
public interface ISysSignInMoodLibraryInfoMapper {

    /**
     * 获取图文素材库详情
     * @param id 素材库ID
     * @return
     */
    SysSignInMoodLibraryInfoDetailVO getDetail(@Param("id") String id);

    /**
     * 获取图文素材库列表
     * @param listDTO {@link SysSignInMoodLibraryInfoListDTO}
     * @return
     */
    List<SysSignInMoodLibraryInfoListVO> getList(@Param("listDTO") SysSignInMoodLibraryInfoListDTO listDTO);
}
