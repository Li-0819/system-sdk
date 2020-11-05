package com.iris.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-29 10:19
 * @description NAME
 */
@Mapper
public interface ISysSignInMoodLibraryInfoInClassificationMapper {


    /**
     * 新增素材库分类与素材库关系表
     * @param classifyIds 签到心情图文素材库分类
     * @param id 签到心情图文素材库ID
     */
    void commonAddInfoInClassify(@Param("classifyIds") List<String> classifyIds, @Param("id") String id);
}
