package com.iris.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-08-26 10:34
 * @description NAME
 */
@Mapper
public interface ICommonMapper {

    /**
     * 新增用户角色关联表
     * @param userId 用户ID
     * @param roleIds 角色ID列表
     */
    void insertUserInRoles(@Param("userId") String userId, @Param("roleIds") List<String> roleIds);

    /**
     * 新增用户与组织机构关联表
     * @param userId 用户ID
     * @param organizationIds 角色ID列表
     */
    void insertUserInOrganization(@Param("userId") String userId, @Param("OrganizationIds") List<String> organizationIds);

    /**
     * 新增用户与职位关联表
     * @param userId 用户ID
     * @param positionIds 角色ID列表
     */
    void insertUserInPosition(@Param("userId") String userId, @Param("positionIds") List<String> positionIds);
}
