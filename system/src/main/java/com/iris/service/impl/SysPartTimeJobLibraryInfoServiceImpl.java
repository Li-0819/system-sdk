package com.iris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysPartTimeJobLibraryInfoMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoEditDTO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoListDTO;
import com.iris.model.entity.SysPartTimeJobLibraryInfo;
import com.iris.model.mapper.SysPartTimeJobLibraryInfoMapper;
import com.iris.model.vo.system.SysPartTimeJobLibraryInfoVO;
import com.iris.service.ISysPartTimeJobLibraryInfoService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 职位描述素材库信息 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysPartTimeJobLibraryInfoServiceImpl extends ServiceImpl<SysPartTimeJobLibraryInfoMapper, SysPartTimeJobLibraryInfo> implements ISysPartTimeJobLibraryInfoService {

    @Resource ISysPartTimeJobLibraryInfoMapper iSysPartTimeJobLibraryInfoMapper;

    /**
     * 获取职位素材库信息列表
     * @param listDTO {@link SysPartTimeJobLibraryInfoListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysPartTimeJobLibraryInfoVO> getList(SysPartTimeJobLibraryInfoListDTO listDTO) {

        PageHelper.startPage(listDTO.getCurrentPage(), listDTO.getPageSize());

        List<SysPartTimeJobLibraryInfoVO> list = iSysPartTimeJobLibraryInfoMapper.getList(listDTO);

        return PageResponseVO.of(list, SysPartTimeJobLibraryInfoVO.class);
    }

    /**
     * 获取职位素材库信息详情
     * @param id 职位素材库信息ID
     * @return
     */
    @Override
    public SysPartTimeJobLibraryInfoVO getDetail(String id) {

        return iSysPartTimeJobLibraryInfoMapper.getDetail(id);
    }

    /**
     * 编辑职位素材库信息
     * @param editDTO {@link SysPartTimeJobLibraryInfoEditDTO}
     */
    @Override
    public void edit(SysPartTimeJobLibraryInfoEditDTO editDTO) {

        SysPartTimeJobLibraryInfo sysPartTimeJobLibraryInfo = DataTransferUtil.model(editDTO, new SysPartTimeJobLibraryInfo());

        if (JudgeParam.isNullOrUndefined(sysPartTimeJobLibraryInfo.getId())){

            baseMapper.insert(sysPartTimeJobLibraryInfo);
        }else {

            JudgeParam.entityIsNotNull(baseMapper.selectById(sysPartTimeJobLibraryInfo.getId()), SystemMsgConstants.SYS_PART_TIME_JOB_LIBRARY_INFO_NOT_EXIST);

            baseMapper.updateById(sysPartTimeJobLibraryInfo);
        }
    }
}
