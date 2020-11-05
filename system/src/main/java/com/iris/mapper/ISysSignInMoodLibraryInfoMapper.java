package com.iris.mapper;


import com.iris.model.vo.system.SysSignInMoodLibraryInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    SysSignInMoodLibraryInfoVO getDetail(@Param("id") String id);
}
