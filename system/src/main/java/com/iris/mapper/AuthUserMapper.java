package com.iris.mapper;

import com.iris.model.vo.UserOrganizationVO;
import com.iris.model.vo.UserRoleVO;
import com.iris.model.vo.UserSiteMapVO;
import com.iris.model.vo.system.EmployeeInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    UserOrganizationVO getOrganizationList(@Param("userId") String userId);

//    /**
//     * 查询菜单
//     * @param userId 用户ID
//     * @return {@link UserSiteMapVO}
//     */
//    List<UserSiteMapVO> getUserSiteMapList(@Param("userId") String userId);

    /**
     * 校验机构编码是否正确
     * @param userId 用户ID
     * @param organizationCode 员工Code
     * @return
     */
    int organizationCodeIsCorrect(@Param("userId") String userId, @Param("organizationCode") String organizationCode);

    /**
     * 验证是否是平台用户
     * @param userId 用户ID
     * @return
     */
    Integer isPlatformUser(@Param("userId") String userId);

    /**
     * 根据userID获取员工信息
     * @param usersId 用户ID
     * @return
     */
    EmployeeInfoVO getEmployeeInfo(String usersId);

    String getTopParentId(@Param("id") String id);
}
