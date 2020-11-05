package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysPositionMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPositionEditDTO;
import com.iris.model.dto.system.SysPositionListDTO;
import com.iris.model.entity.SysPosition;
import com.iris.model.mapper.SysPositionMapper;
import com.iris.model.vo.system.SysPositionVO;
import com.iris.service.ISysPositionService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 职位信息表 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements ISysPositionService {

    @Resource private ISysPositionMapper iSysPositionMapper;

    /**
     * 获取职位信息列表
     * @param sysPositionListDTO {@link SysPositionListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysPositionVO> getList(SysPositionListDTO sysPositionListDTO) {

        PageHelper.startPage(sysPositionListDTO.getCurrentPage(), sysPositionListDTO.getPageSize());

        List<SysPositionVO> sysPositionVOS =iSysPositionMapper.getList(sysPositionListDTO);

        return PageResponseVO.of(sysPositionVOS, SysPositionVO.class);
    }

    /**
     * 校验是否存在相同名称与编码数据
     * @param id 职位信息ID
     * @param organizationsId 机构编码
     * @param positionName 机构名称
     * @return
     */
    @Override
    public boolean checkRepeat(String id, String organizationsId, String positionName) {

        List<SysPosition> sysPositions = baseMapper.selectList(new QueryWrapper<SysPosition>() {{
            eq(SystemCommonField.ORGANIZATIONS_ID, organizationsId)
                    .eq(SystemCommonField.POSITION_NAME, positionName);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysPositions.size() > 0;
    }

    /**
     * 编辑职位信息
     * @param sysPositionEditDTO {@link SysPositionEditDTO}
     */
    @Override
    public void edit(SysPositionEditDTO sysPositionEditDTO) {

        SysPosition sysPosition = DataTransferUtil.model(sysPositionEditDTO, new SysPosition());

        if (JudgeParam.isNullOrUndefined(sysPosition.getId())){

            baseMapper.insert(sysPosition);
        }else {

            SysPosition position = baseMapper.selectOne(new QueryWrapper<SysPosition>() {{
                eq(SystemCommonField.ID, sysPosition.getId())
                        .eq(SystemCommonField.IS_LOCKED, 0);
            }});

            JudgeParam.entityIsNotNull(position, SystemMsgConstants.SYS_POSITION_NOT_EXIST);

            baseMapper.updateById(sysPosition);
        }
    }

    /**
     * 获取职位信息详情
     * @param id 职位信息ID
     * @return
     */
    @Override
    public SysPositionVO getDetail(String id) {

        return iSysPositionMapper.getDetail(id);
    }
}
