package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iris.mapper.SysSignInMoodLibraryInfoInClassificationMapper;
import com.iris.model.entity.SysSignInMoodLibraryInfoInClassification;
import com.iris.model.entity.SysUserInOrganization;
import com.iris.model.entity.SysUserInPosition;
import com.iris.model.entity.SysUserInRole;
import com.iris.model.mapper.SysUserInOrganizationMapper;
import com.iris.model.mapper.SysUserInPositionMapper;
import com.iris.model.mapper.SysUserInRoleMapper;
import com.iris.service.ICommonService;
import com.iris.utils.constants.SystemCommonField;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Resource;

/**
 * @author WindChaser
 * @createTime 2020-08-26 10:28
 * @description NAME
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Resource private SysUserInRoleMapper sysUserInRoleMapper;

    @Resource private SysUserInPositionMapper sysUserInPositionMapper;

    @Resource private SysUserInOrganizationMapper sysUserInOrganizationMapper;

    @Resource private SysSignInMoodLibraryInfoInClassificationMapper sysSignInMoodLibraryInfoInClassificationMapper;

    /**
     * 根据不同的关联类型删除不同的 关联表
     * @param targetId 目标ID
     * @param relevanceType 关联类型  position/roles/organization ...
     */
    @Override
    public void deleteUserRelevance(String targetId, @Nonnull String relevanceType) {

        if (SystemCommonField.ROLE.equals(relevanceType)){

            sysUserInRoleMapper.delete(new QueryWrapper<SysUserInRole>(){{
                eq(SystemCommonField.USER_ID, targetId);
            }});
        }else if (SystemCommonField.POSITION.equals(relevanceType)){

            sysUserInPositionMapper.delete(new QueryWrapper<SysUserInPosition>(){{
                eq(SystemCommonField.USER_ID, targetId);
            }});
        }else if (SystemCommonField.ORGANIZATION.equals(relevanceType)){

            // 员工与机构
            sysUserInOrganizationMapper.delete(new QueryWrapper<SysUserInOrganization>(){{
                eq(SystemCommonField.USER_ID, targetId);
            }});
        }else if (SystemCommonField.SIGN_IN_MOOD_LIBRARY.equals(relevanceType)){

            //  图文素材库与分类
            sysSignInMoodLibraryInfoInClassificationMapper.delete(new QueryWrapper<SysSignInMoodLibraryInfoInClassification>(){{
                eq(SystemCommonField.MOOD_LIBRARY_INFO_ID, targetId);
            }});
        }
    }
}
