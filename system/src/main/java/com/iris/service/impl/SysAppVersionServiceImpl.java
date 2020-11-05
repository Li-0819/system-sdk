package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysAppVersionMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysAppVersionEditDTO;
import com.iris.model.dto.system.SysAppVersionListDTO;
import com.iris.model.entity.SysAppVersion;
import com.iris.model.mapper.SysAppVersionMapper;
import com.iris.model.vo.system.SysAppVersionVO;
import com.iris.service.ISysAppVersionService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 应用版本信息 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysAppVersionServiceImpl extends ServiceImpl<SysAppVersionMapper, SysAppVersion> implements ISysAppVersionService {

    @Resource private ISysAppVersionMapper iSysAppVersionMapper;

    /**
     * 获取应用版本信息列表
     * @param sysAppVersionListDTO {@link SysAppVersionListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysAppVersionVO> getList(SysAppVersionListDTO sysAppVersionListDTO) {

        PageHelper.startPage(sysAppVersionListDTO.getCurrentPage(),sysAppVersionListDTO.getPageSize());

        return PageResponseVO.of(iSysAppVersionMapper.getList(sysAppVersionListDTO),SysAppVersionVO.class);
    }

    /**
     * 编辑应用版本信息
     * @param sysAppVersionEditDTO {@link SysAppVersionEditDTO}
     */
    @Override
    public void edit(SysAppVersionEditDTO sysAppVersionEditDTO) {

        SysAppVersion appVersion = DataTransferUtil.model(sysAppVersionEditDTO, new SysAppVersion());

        if (JudgeParam.isNullOrUndefined(appVersion.getId())) {

            baseMapper.insert(appVersion);
        } else {

            JudgeParam.entityIsNotNull(baseMapper.selectById(appVersion.getId()), SystemMsgConstants.APP_VERSION_NOT_FOUND);

            baseMapper.updateById(appVersion);
        }
    }

    /**
     * 获取应用版本信息详情
     * @param id {@link "应用版本信息ID"}
     * @return
     */
    @Override
    public SysAppVersionVO getDetail(String id) {

        return iSysAppVersionMapper.getDetail(id);
    }

    /**
     * 校验是否重复
     * @param appName 应用名称
     * @param id 应用版本信息ID
     * @return
     */
    @Override
    public boolean checkRepeat(String appName, String appCode, String id) {

        List<SysAppVersion> sysAppVersion = baseMapper.selectList(new QueryWrapper<SysAppVersion>(){{
            and(wrapper->{

                wrapper.eq(SystemCommonField.APP_TYPE, appName)
                        .or()
                        .eq(SystemCommonField.APP_CODE, appCode);
            });

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysAppVersion.size() > 0;
    }
}
