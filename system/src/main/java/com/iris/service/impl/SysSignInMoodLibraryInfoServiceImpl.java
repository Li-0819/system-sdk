package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysSignInMoodLibraryInfoInClassificationMapper;
import com.iris.mapper.ISysSignInMoodLibraryInfoMapper;
import com.iris.mapper.SysSignInMoodLibraryInfoMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoListDTO;
import com.iris.model.entity.SysSignInMoodLibraryInfo;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoVO;
import com.iris.service.ICommonService;
import com.iris.service.ISysSignInMoodLibraryInfoService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 签到心情图文素材库 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysSignInMoodLibraryInfoServiceImpl extends ServiceImpl<SysSignInMoodLibraryInfoMapper, SysSignInMoodLibraryInfo> implements ISysSignInMoodLibraryInfoService {

    @Resource private ISysSignInMoodLibraryInfoMapper iSysSignInMoodLibraryInfoMapper;

    @Resource private ISysSignInMoodLibraryInfoInClassificationMapper iSysSignInMoodLibraryInfoInClassificationMapper;

    @Resource private ICommonService iCommonService;

    /**
     * 获取签到心情图文素材库列表
     * @param sysSignInMoodLibraryInfoListDTO {@link SysSignInMoodLibraryInfoListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysSignInMoodLibraryInfoVO> getList(SysSignInMoodLibraryInfoListDTO sysSignInMoodLibraryInfoListDTO) {

        PageHelper.startPage(sysSignInMoodLibraryInfoListDTO.getCurrentPage(), sysSignInMoodLibraryInfoListDTO.getPageSize());

        List<SysSignInMoodLibraryInfo> pageList = baseMapper.selectList(new QueryWrapper<SysSignInMoodLibraryInfo>() {{

            if (!JudgeParam.isNullOrUndefined(sysSignInMoodLibraryInfoListDTO.getLibraryName())){

                like(SystemCommonField.LIBRARY_NAME, sysSignInMoodLibraryInfoListDTO.getLibraryName());
            }

            orderByDesc(SystemCommonField.CREATED_TIME);
        }});

        return PageResponseVO.of(pageList, SysSignInMoodLibraryInfoVO.class);
    }

    /**
     * 校验素材库素材名称是否重复
     * @param libraryName 素材名称
     * @param id 素材库ID
     * @return
     */
    @Override
    public boolean checkNameRepeat(String libraryName, String id) {

        List<SysSignInMoodLibraryInfo> sysSignInMoodLibraryInfos = baseMapper.selectList(new QueryWrapper<SysSignInMoodLibraryInfo>(){{
            eq(SystemCommonField.LIBRARY_NAME, libraryName);

            if (!JudgeParam.isNullOrUndefined(id)){

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysSignInMoodLibraryInfos.size() > 0;
    }

    /**
     * 编辑图文素材库
     * @param sysSignInMoodLibraryInfoEditDTO {@link SysSignInMoodLibraryInfoEditDTO}
     */
    @Override
    public void edit(SysSignInMoodLibraryInfoEditDTO sysSignInMoodLibraryInfoEditDTO) {

        SysSignInMoodLibraryInfo libraryInfo = DataTransferUtil.model(sysSignInMoodLibraryInfoEditDTO, new SysSignInMoodLibraryInfo());

        if (JudgeParam.isNullOrUndefined(libraryInfo.getId())){

            baseMapper.insert(libraryInfo);
        }else {

            SysSignInMoodLibraryInfo sysSignInMoodLibraryInfo = baseMapper.selectById(libraryInfo.getId());

            JudgeParam.entityIsNotNull(sysSignInMoodLibraryInfo, SystemMsgConstants.COMMODITY_LIBRARY_NOT_FOUND);

            baseMapper.updateById(libraryInfo);
            iCommonService.deleteUserRelevance(libraryInfo.getId(), SystemCommonField.SIGN_IN_MOOD_LIBRARY);
        }

        if (sysSignInMoodLibraryInfoEditDTO.getClassifyIds().size() > 0) {

            iSysSignInMoodLibraryInfoInClassificationMapper.commonAddInfoInClassify(sysSignInMoodLibraryInfoEditDTO.getClassifyIds(),libraryInfo.getId());
        }
    }

    /**
     * 获取图文素材库详情
     * @param id 素材库ID
     * @return
     */
    @Override
    public SysSignInMoodLibraryInfoVO getDetail(String id) {

        return iSysSignInMoodLibraryInfoMapper.getDetail(id);
    }
}
