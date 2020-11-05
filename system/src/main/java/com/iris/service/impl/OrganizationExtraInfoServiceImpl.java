package com.iris.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.IOrganizationExtraInfoMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.organization.OrganizationExtraInfoEditDTO;
import com.iris.model.dto.organization.OrganizationExtraInfoListDTO;
import com.iris.model.entity.OrganizationExtraInfo;
import com.iris.model.mapper.OrganizationExtraInfoMapper;
import com.iris.model.vo.organization.OrganizationExtraInfoDetailVO;
import com.iris.model.vo.organization.OrganizationExtraInfoListVO;
import com.iris.service.AttachmentService;
import com.iris.service.IOrganizationExtraInfoService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.constants.SystemSpecialCode;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 机构附属信息 服务实现类
 * </p>
 *
 * @author amaterasu
 * @since 2020-09-18
 */
@Service
public class OrganizationExtraInfoServiceImpl extends ServiceImpl<OrganizationExtraInfoMapper, OrganizationExtraInfo> implements IOrganizationExtraInfoService {

    @Resource
    private IOrganizationExtraInfoMapper iOrganizationExtraInfoMapper;

    @Resource private AttachmentService attachmentService;

    /**
     * 获取机构信息列表
     * @param organizationExtraInfoListDTO {@link OrganizationExtraInfoListDTO}
     * @return
     */
    @Override
    public PageResponseVO<OrganizationExtraInfoListVO> getList(OrganizationExtraInfoListDTO organizationExtraInfoListDTO) {

        PageHelper.startPage(organizationExtraInfoListDTO.getCurrentPage(), organizationExtraInfoListDTO.getPageSize());

        List<OrganizationExtraInfoListVO> organizationInfoListVOList = iOrganizationExtraInfoMapper.getList(organizationExtraInfoListDTO);

        return PageResponseVO.of(organizationInfoListVOList, OrganizationExtraInfoListVO.class);
    }

    /**
     * 获取机构信息详情
     * @param id 机构信息ID
     * @return
     */
    @Override
    public OrganizationExtraInfoDetailVO getDetail(String id) {

        OrganizationExtraInfoDetailVO detailVO = iOrganizationExtraInfoMapper.getDetail(id, null);

//        detailVO.setAttachInfoVOS(attachmentService.getAttachesByRefId(id));

        return detailVO;
    }

    /**
     * 编辑机构信息
     * @param organizationExtraInfoEditDTO {@link OrganizationExtraInfoEditDTO}
     */
    @Override
    public void edit(OrganizationExtraInfoEditDTO organizationExtraInfoEditDTO) {

        OrganizationExtraInfo organizationInfo = DataTransferUtil.model(organizationExtraInfoEditDTO, new OrganizationExtraInfo());

        if (JudgeParam.isNullOrUndefined(organizationExtraInfoEditDTO.getId())){

            organizationInfo.setOrganizationStatus(SystemSpecialCode.TO_AUDIT);

            baseMapper.insert(organizationInfo);
        }else {

            OrganizationExtraInfo organizationInfo1 = baseMapper.selectOne(new QueryWrapper<OrganizationExtraInfo>() {{
                eq(SystemCommonField.ID, organizationInfo.getId())
                        .ne(SystemCommonField.ORGANIZATION_STATUS, SystemSpecialCode.AUDIT_LOCK);
            }});

            JudgeParam.entityIsNotNull(organizationInfo1, SystemMsgConstants.ORGANIZATION_INFO_NOT_EXIST);

            baseMapper.updateById(organizationInfo);

//            attachmentService.removeAttachesByRefId(organizationExtraInfoEditDTO.getId(), organizationExtraInfoEditDTO.getAttachIds());
        }

//        attachmentService.updateRefIdForAttaches(organizationInfo.getId(), organizationExtraInfoEditDTO.getAttachIds());
    }

    /**
     * 审核
     * @param id 机构ID
     * @param status 状态
     */
    @Override
    public void audit(String id, String status) {

        iOrganizationExtraInfoMapper.audit(id,status);
    }

    /**
     * 校验机构是否重复
     * @param id 机构信息ID
     * @param unifiedCreditCode 统一信用代码
     * @return
     */
    @Override
    public boolean checkRepeat(String id, String unifiedCreditCode) {

        Integer integer = baseMapper.selectCount(new QueryWrapper<OrganizationExtraInfo>() {{
            eq(SystemCommonField.UNIFIED_CREDIT_CODE, unifiedCreditCode);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return integer > 0;
    }
}
