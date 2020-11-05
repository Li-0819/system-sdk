package com.iris.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysSignInMoodLibraryInfoClassificationMapper;
import com.iris.mapper.SysSignInMoodLibraryInfoClassificationMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationListDTO;
import com.iris.model.entity.SysSignInMoodLibraryInfoClassification;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoClassificationVO;
import com.iris.service.ISysSignInMoodLibraryInfoClassificationService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 签到心情图文素材库分类 服务实现类
 * </p>
 *
 * @author WindChaser
 * @since 2020-07-27
 */
@Service
public class SysSignInMoodLibraryInfoClassificationServiceImpl extends ServiceImpl<SysSignInMoodLibraryInfoClassificationMapper, SysSignInMoodLibraryInfoClassification> implements ISysSignInMoodLibraryInfoClassificationService {

    @Resource private ISysSignInMoodLibraryInfoClassificationMapper iSysSignInMoodLibraryInfoClassificationMapper;

    /**
     * 查询签到心情图文素材库分类列表
     * @param listDTO {@link SysSignInMoodLibraryInfoClassificationListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysSignInMoodLibraryInfoClassificationVO> getList(SysSignInMoodLibraryInfoClassificationListDTO listDTO) {

        PageHelper.startPage(listDTO.getCurrentPage(), listDTO.getPageSize());

        List<SysSignInMoodLibraryInfoClassificationVO> list = iSysSignInMoodLibraryInfoClassificationMapper.getList(listDTO);

        return PageResponseVO.of(list, SysSignInMoodLibraryInfoClassificationVO.class);
    }

    /**
     * 校验素材库分类
     * @param name 名称
     * @param code 编码
     * @param id 素材库分类ID
     * @return
     */
    @Override
    public boolean checkRepeat(String name, String code, String id) {

        List<SysSignInMoodLibraryInfoClassification> selectList = baseMapper.selectList(new QueryWrapper<SysSignInMoodLibraryInfoClassification>(){{
            and(wrapper ->
                    wrapper.eq(SystemCommonField.NAME, name).or()
                                    .eq(SystemCommonField.CODE, code));

            if (!JudgeParam.isNullOrUndefined(id)){

                ne(SystemCommonField.ID, id);
            }
        }});

        return selectList.size() > 0;
    }

    /**
     * 编辑素材库分类
     * @param editDTO {@link SysSignInMoodLibraryInfoClassificationEditDTO}
     */
    @Override
    public void edit(SysSignInMoodLibraryInfoClassificationEditDTO editDTO) {

        SysSignInMoodLibraryInfoClassification libraryInfoClassification = DataTransferUtil.model(editDTO, new SysSignInMoodLibraryInfoClassification());

        if (JudgeParam.isNullOrUndefined(libraryInfoClassification.getId())){

            baseMapper.insert(libraryInfoClassification);
        }else {

            SysSignInMoodLibraryInfoClassification signInMoodLibraryInfoClassification = baseMapper.selectById(libraryInfoClassification.getId());

            JudgeParam.entityIsNotNull(signInMoodLibraryInfoClassification, SystemMsgConstants.COMMODITY_LIBRARY_TYPE_NOT_FOUND);

            baseMapper.updateById(signInMoodLibraryInfoClassification);
        }
    }

    /**
     * 签到心情图文素材库分类详情
     * @param id ID
     * @return
     */
    @Override
    public SysSignInMoodLibraryInfoClassificationVO getDetail(String id) {

        return iSysSignInMoodLibraryInfoClassificationMapper.getDetail(id);
    }
}
