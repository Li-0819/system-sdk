package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysBannerMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysBannerEditDTO;
import com.iris.model.dto.system.SysBannerListDTO;
import com.iris.model.entity.SysBanner;
import com.iris.model.mapper.SysBannerMapper;
import com.iris.model.vo.system.SysBannerVO;
import com.iris.service.AttachmentService;
import com.iris.service.ISysBannerService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 * banner信息 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysBannerServiceImpl extends ServiceImpl<SysBannerMapper, SysBanner> implements ISysBannerService {

    @Resource private ISysBannerMapper iSysBannerMapper;

    @Resource private AttachmentService attachmentService;

    /**
     * 获取banner信息列表
     * @param sysBannerListDTO {@link SysBannerEditDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysBannerVO> getList(SysBannerListDTO sysBannerListDTO) {

        PageHelper.startPage(sysBannerListDTO.getCurrentPage(), sysBannerListDTO.getPageSize());

        return PageResponseVO.of(iSysBannerMapper.getList(sysBannerListDTO),SysBannerVO.class);
    }

    /**
     * 编辑banner信息
     * @param sysBannerEditDTO {@link SysBannerEditDTO}
     */
    @Override
    public void edit(SysBannerEditDTO sysBannerEditDTO) {

        SysBanner sysBanner = DataTransferUtil.model(sysBannerEditDTO, new SysBanner());

        if (JudgeParam.isNullOrUndefined(sysBanner.getId())) {

            baseMapper.insert(sysBanner);
        } else {

            SysBanner selectOne = baseMapper.selectById(sysBannerEditDTO.getId());

            JudgeParam.entityIsNotNull(selectOne, SystemMsgConstants.BANNER_NOT_EXIST);

            baseMapper.updateById(sysBanner);
        }

        attachmentService.updateRefIdForAttaches(sysBanner.getId(), sysBannerEditDTO.getAttachIds());
    }

    /**
     * 获取banner信息详情
     * @param id {@link 'banner信息ID'}
     * @return
     */
    @Override
    public SysBannerVO getDetail(String id) {

        SysBannerVO sysBannerVO = iSysBannerMapper.getDetail(id);

        sysBannerVO.setAttachInfoVOS(attachmentService.getAttachesByRefId(id));

        return sysBannerVO;
    }
}
