package com.iris.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author WindChaser
 * @createTime 2020-08-26 09:37
 * @description NAME
 */
@Mapper
public interface ISitemapActionAuthorityMapper {

    /**
     * 根据targetId删除数据
     * @param targetId 目标ID
     */
    void deleteByTargetId(@Param("targetId") String targetId);
}
