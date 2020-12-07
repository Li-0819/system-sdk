package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.EmployeeMapper;
import com.iris.mapper.ISysOrganizationsMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOrganizationsEditDTO;
import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.dto.system.UserEditDTO;
import com.iris.model.entity.*;
import com.iris.model.mapper.OrganizationExtraInfoMapper;
import com.iris.model.mapper.SysOrganizationsMapper;
import com.iris.model.mapper.SysRolesMapper;
import com.iris.model.vo.system.SysOrganizationsListVO;
import com.iris.service.IMemberInEmployeeInUserInOrganizationService;
import com.iris.service.ISysOrganizationsService;
import com.iris.service.ISysUsersService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.constants.SystemSpecialCode;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysOrganizationsServiceImpl extends ServiceImpl<SysOrganizationsMapper, SysOrganizations> implements ISysOrganizationsService {

    @Resource private ISysOrganizationsMapper iSysOrganizationsMapper;

    @Resource private OrganizationExtraInfoMapper organizationExtraInfoMapper;

    @Resource private ISysUsersService iSysUsersService;

    @Resource private SysRolesMapper sysRolesMapper;

    @Resource private IMemberInEmployeeInUserInOrganizationService iMemberInEmployeeInUserInOrganizationService;

    @Resource private EmployeeMapper employeeMapper;


    /**
     * 获取组织机构列表
     * @param sysOrganizationsListDTO {@link SysOrganizationsListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysOrganizationsListVO> getList(SysOrganizationsListDTO sysOrganizationsListDTO) {

        PageHelper.startPage(sysOrganizationsListDTO.getCurrentPage(), sysOrganizationsListDTO.getPageSize());

        List<SysOrganizationsListVO> sysOrganizations = iSysOrganizationsMapper.getList(sysOrganizationsListDTO);

        return PageResponseVO.of(sysOrganizations, SysOrganizationsListVO.class);
    }

    /**
     * 校验组织机构相同parentId下是否有重复名称或者编码
     * @param id 组织机构ID
     * @param parentId 父节点ID
     * @param code 编码
     * @param name 名称
     * @return
     */
    @Override
    public boolean checkRepeat(String id, String parentId, String code, String name) {

        Integer integer = iSysOrganizationsMapper.checkRepeat(id, parentId, code, name);

        return integer> 0;
    }

    /**
     * 编辑组织机构
     * @param sysOrganizationsEditDTO {@link SysOrganizationsEditDTO}
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(SysOrganizationsEditDTO sysOrganizationsEditDTO) {

        SysOrganizations sysOrganizations = DataTransferUtil.model(sysOrganizationsEditDTO, new SysOrganizations());

        if (JudgeParam.isNullOrUndefined(sysOrganizations.getId())){

            baseMapper.insert(sysOrganizations);

        }else {

            SysOrganizations organizations = baseMapper.selectOne(new QueryWrapper<SysOrganizations>() {{
                eq(SystemCommonField.ID, sysOrganizations.getId())
                        .eq(SystemCommonField.IS_LOCKED, 0);
            }});

            JudgeParam.entityIsNotNull(organizations, SystemMsgConstants.SYS_ORGANIZATIONS_NOT_EXIST);

            baseMapper.updateById(sysOrganizations);
        }
    }

    /**
     * 获取组织机构详情
     * @param id ID
     * @return
     */
    @Override
    public SysOrganizationsListVO getDetail(String id) {

        return iSysOrganizationsMapper.getDetail(id,null);
    }

    /**
     * 审核
     * @param id 机构ID
     * @param status 状态
     */
    @Override
    public void audit(String id, String status) {

        Integer isLocked = status.equals(SystemSpecialCode.AUDIT_LOCK) ? 1 : 0;

        iSysOrganizationsMapper.updateIsLockedById(id,isLocked);
    }

    /**
     * 新建机构保存关联信息
     * @param sysOrganizationsEditDTO
     * @param organizationId
     * @param organizationCode
     */
    public void saveOrgAttachInfo(SysOrganizationsEditDTO sysOrganizationsEditDTO, String organizationId, String organizationCode){

        JudgeParam.entityIsNotNull(sysOrganizationsEditDTO.getUserEditDTO(), SystemMsgConstants.SUPER_ADMIN_NOT_FOUNT);
        UserEditDTO userEditDTO = sysOrganizationsEditDTO.getUserEditDTO();
        userEditDTO.setIsDefault(1);

        SysRoles sysRoles = sysRolesMapper.selectOne(new QueryWrapper<SysRoles>() {{
            eq(SystemCommonField.CODE, SystemCommonField.ORG_ADMIN);
        }});

        if (null != sysRoles){

            ArrayList<String> roleIds = new ArrayList<>();
            roleIds.add(sysRoles.getId());

            userEditDTO.setRoleIds(roleIds);
        }

        SysUsers sysUsers = iSysUsersService.edit(userEditDTO);

        EmployeeInfoEntity employeeInfoEntity = new EmployeeInfoEntity();
        employeeInfoEntity.setEmployeeCode(organizationCode+ '-' + 1);
        employeeInfoEntity.setEmployeeName(sysUsers.getRealName());
        employeeInfoEntity.setGender(sysUsers.getGender());
        employeeInfoEntity.setRemark(sysUsers.getRemark());
        employeeInfoEntity.setEmployeeClass(SystemSpecialCode.ORG_ADMIN);
        employeeInfoEntity.setMobileNumber(sysUsers.getPhoneNumber());
        employeeInfoEntity.setEmployeeStatus(SystemSpecialCode.BE_ON_THE_JOB);
        employeeMapper.insert(employeeInfoEntity);

        MemberInEmployeeInUserInOrganization memberInEmployeeInUserInOrganization = new MemberInEmployeeInUserInOrganization();
        memberInEmployeeInUserInOrganization.setUserId(sysUsers.getId());
        memberInEmployeeInUserInOrganization.setOrganizationId(organizationId);
        memberInEmployeeInUserInOrganization.setEmployeeId(employeeInfoEntity.getId());
        iMemberInEmployeeInUserInOrganizationService.save(memberInEmployeeInUserInOrganization);
    }
}
