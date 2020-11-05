package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysIntegralSettingInfoMapper;
import com.iris.mapper.SysIntegralSettingInfoMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysIntegralSettingInfoEditDTO;
import com.iris.model.dto.system.SysIntegralSettingInfoListDTO;
import com.iris.model.entity.SysIntegralSettingInfo;
import com.iris.model.vo.system.SysIntegralSettingInfoVO;
import com.iris.service.ISysIntegralSettingInfoService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 积分配置信息 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysIntegralSettingInfoServiceImpl extends ServiceImpl<SysIntegralSettingInfoMapper, SysIntegralSettingInfo> implements ISysIntegralSettingInfoService {

    @Resource private ISysIntegralSettingInfoMapper iSysIntegralSettingInfoMapper;

    /**
     * 获取积分配置信息列表
     * @param sysIntegralSettingInfoListDTO {@link SysIntegralSettingInfoListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysIntegralSettingInfoVO> getList(SysIntegralSettingInfoListDTO sysIntegralSettingInfoListDTO) {

        PageHelper.startPage(sysIntegralSettingInfoListDTO.getCurrentPage(), sysIntegralSettingInfoListDTO.getPageSize());

        List<SysIntegralSettingInfoVO> list = iSysIntegralSettingInfoMapper.getList(sysIntegralSettingInfoListDTO);

        return PageResponseVO.of(list, SysIntegralSettingInfoVO.class);
    }

    /**
     * 校验积分,编码复合主键是否重复
     * @param integralName 积分名称
     * @param integralCode 积分编码
     * @param id 积分配置信息ID
     * @return
     */
    @Override
    public boolean checkNameAndCodeRepeat(String integralName, String integralCode, String id) {

        List<SysIntegralSettingInfo> sysIntegralSettingInfos = baseMapper.selectList(new QueryWrapper<SysIntegralSettingInfo>(){{
            eq(SystemCommonField.INTEGRAL_NAME, integralName)
                    .eq(SystemCommonField.INTEGRAL_CODE, integralCode);

            if (!JudgeParam.isNullOrUndefined(id)){

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysIntegralSettingInfos.size() > 0;
    }

    /**
     * 编辑积分配置信息
     * @param sysIntegralSettingInfoEditDTO {@link SysIntegralSettingInfoEditDTO}
     */
    @Override
    public void edit(SysIntegralSettingInfoEditDTO sysIntegralSettingInfoEditDTO) {

        SysIntegralSettingInfo sysIntegralSettingInfo = DataTransferUtil.model(sysIntegralSettingInfoEditDTO, new SysIntegralSettingInfo());

        if (JudgeParam.isNullOrUndefined(sysIntegralSettingInfo.getId())){

            baseMapper.insert(sysIntegralSettingInfo);
        }else {

            SysIntegralSettingInfo integralSettingInfo = baseMapper.selectById(sysIntegralSettingInfo.getId());

            JudgeParam.entityIsNotNull(integralSettingInfo, SystemMsgConstants.INTEGRAL_SETTING_INFO_NOT_EXIST);

            baseMapper.updateById(sysIntegralSettingInfo);
        }
    }

    @Override
    public SysIntegralSettingInfoVO getDetail(String id) {

        return iSysIntegralSettingInfoMapper.getDetail(id);
    }
}
