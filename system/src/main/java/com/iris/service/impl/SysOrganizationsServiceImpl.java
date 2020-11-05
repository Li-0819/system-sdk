package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysOrganizationsMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOrganizationsEditDTO;
import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.entity.SysOrganizations;
import com.iris.model.mapper.SysOrganizationsMapper;
import com.iris.model.vo.system.SysOrganizationsVO;
import com.iris.service.ISysOrganizationsService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 获取组织机构列表
     * @param sysOrganizationsListDTO {@link SysOrganizationsListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysOrganizationsVO> getList(SysOrganizationsListDTO sysOrganizationsListDTO) {

        PageHelper.startPage(sysOrganizationsListDTO.getCurrentPage(), sysOrganizationsListDTO.getPageSize());

        List<SysOrganizationsVO> sysOrganizations = iSysOrganizationsMapper.getList(sysOrganizationsListDTO);

        return PageResponseVO.of(sysOrganizations, SysOrganizationsVO.class);
    }

    /**
     * 校验组织机构相同parentId下是否有重新名称或者编码
     * @param id 组织机构ID
     * @param parentId 父节点ID
     * @param code 编码
     * @param name 名称
     * @return
     */
    @Override
    public boolean checkRepeat(String id, String parentId, String code, String name) {

        List<SysOrganizations> sysOrganizations = baseMapper.selectList(new QueryWrapper<SysOrganizations>() {{

            if (JudgeParam.isNullOrUndefined(parentId)){

                and(wrapper -> {
                    wrapper.eq(SystemCommonField.PARENT_ID,"")
                            .or()
                            .isNull(SystemCommonField.PARENT_ID);
                });
            } else {

                eq(SystemCommonField.PARENT_ID, parentId);
            }

            and(wrapper -> {
                wrapper.eq(SystemCommonField.CODE, code)
                        .or()
                        .eq(SystemCommonField.NAME, name);
            });

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysOrganizations.size() > 0;
    }

    /**
     * 编辑组织机构
     * @param sysOrganizationsEditDTO {@link SysOrganizationsEditDTO}
     */
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
    public SysOrganizationsVO getDetail(String id) {

        return iSysOrganizationsMapper.getDetail(id,null);
    }
}
