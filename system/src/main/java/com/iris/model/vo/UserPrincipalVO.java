package com.iris.model.vo;

import com.iris.model.entity.SysUsers;
import com.iris.model.vo.system.EmployeeInfoVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: izanagi
 * @Date: 2020-06-28 15:06
 * @Description: UserPrincipalVO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPrincipalVO implements UserDetails {

    private String name;
    private String avatar;
    private Boolean service;
    /**
     * id
     */
    private String id;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 密码
     */
    private String loginPwd;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电话
     */
    private String phoneNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * isLocked
     */
    private Integer isLocked;

    /**
     * isDeleted
     */
    private Integer isDeleted;

    /**
     * 用户角色
     */
    List<UserRoleVO> roles;

    /**
     * 用户权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;

    private List<UserOrganizationVO> organizationList;

    private List<UserSiteMapVO> userSiteMapList;


    public static UserPrincipalVO create(SysUsers user, List<UserRoleVO> roles, List<UserOrganizationVO> organizations, List<UserSiteMapVO> sysSiteMaps, EmployeeInfoVO employeeInfoVO) {

        List<GrantedAuthority> authorities = sysSiteMaps.stream().map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());

        String employeeNoteName = null, avatar = null;
        if (null != employeeInfoVO){
            employeeNoteName = employeeInfoVO.getEmployeeNoteName();
            avatar = employeeInfoVO.getAvatar();
        }

        return new UserPrincipalVO(employeeNoteName, avatar, true, user.getId(), user.getLoginName(), user.getLoginPwd(), user.getRealName(), user.getGender(), user.getPhoneNumber(),
                user.getRemark(), user.getIsLocked(), user.getIsDeleted(), roles, authorities, organizations, sysSiteMaps);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return loginPwd;
    }

    @Override
    public String getUsername() {
        return loginName;
    }

    /**
     * 账号未过期
     * @return {@link Boolean}
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号未锁定
     * @return {@link Boolean}
     */
    @Override
    public boolean isAccountNonLocked() {
        return Objects.equals(this.isLocked, 0);
    }

    /**
     * 凭证未过期
     * @return {@link Boolean}
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账号未禁用
     * @return {@link Boolean}
     */
    @Override
    public boolean isEnabled() {
        return Objects.equals(this.isDeleted, 0);
    }
}
