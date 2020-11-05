package com.iris.mapper;

import com.iris.model.vo.UserOrganizationVO;
import com.iris.model.vo.UserRoleVO;
import com.iris.model.vo.UserSiteMapVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统代码 Mapper 接口
 * </p>
 *
 * @author izanagi
 * @since 2020-06-03
 */
@Mapper
public interface AuthUserMapper {

    /**
     * 用户角色
     * @param userId 用户ID
     * @return {@link UserRoleVO}
     */
    List<UserRoleVO> getRoles(@Param("userId") String userId);

    /**
     * 组织部门
     * @param userId 用户ID
     * @return {@link UserOrganizationVO}
     */
    List<UserOrganizationVO> getOrganizationList(@Param("userId") String userId);

    /**
     * 查询菜单
     * @param userId 用户ID
     * @return {@link UserSiteMapVO}
     */
    List<UserSiteMapVO> getUserSiteMapList(@Param("userId") String userId);

}
