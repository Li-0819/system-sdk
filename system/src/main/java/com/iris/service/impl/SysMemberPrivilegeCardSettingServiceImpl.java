package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysMemberPrivilegeCardSettingMapper;
import com.iris.mapper.SysMemberPrivilegeCardSettingMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingEditDTO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingListDTO;
import com.iris.model.entity.SysMemberPrivilegeCardSetting;
import com.iris.model.vo.system.SysMemberPrivilegeCardSettingVO;
import com.iris.service.ISysMemberPrivilegeCardSettingService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 会员特权卡设置 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysMemberPrivilegeCardSettingServiceImpl extends ServiceImpl<SysMemberPrivilegeCardSettingMapper, SysMemberPrivilegeCardSetting> implements ISysMemberPrivilegeCardSettingService {

    @Resource private ISysMemberPrivilegeCardSettingMapper iSysMemberPrivilegeCardSettingMapper;

    /**
     * 获取会员特权卡设置
     * @param listDTO {@link SysMemberPrivilegeCardSettingListDTO}
     * @return
     */
    @Override
    public PageResponseVO<SysMemberPrivilegeCardSettingVO> getList(SysMemberPrivilegeCardSettingListDTO listDTO) {

        PageHelper.startPage(listDTO.getCurrentPage(), listDTO.getPageSize());

        List<SysMemberPrivilegeCardSettingVO> pageList = iSysMemberPrivilegeCardSettingMapper.getList(listDTO);

        return PageResponseVO.of(pageList, SysMemberPrivilegeCardSettingVO.class);
    }

    /**
     * 校验会员特权卡分类是否重复
     * @param type 分类
     * @param id 会员特权卡ID
     * @return
     */
    @Override
    public boolean checkTypeRepeat(String type, String id) {

        List<SysMemberPrivilegeCardSetting> sysMemberPrivilegeCardSettings = baseMapper.selectList(new QueryWrapper<SysMemberPrivilegeCardSetting>(){{
            eq(SystemCommonField.TYPE, type);

            if (!JudgeParam.isNullOrUndefined(id)){

                ne(SystemCommonField.ID, id);
            }
        }});

        return sysMemberPrivilegeCardSettings.size() > 0;
    }

    /**
     * 编辑会员特权卡设置
     * @param sysMemberPrivilegeCardSettingEditDTO
     */
    @Override
    public void edit(SysMemberPrivilegeCardSettingEditDTO sysMemberPrivilegeCardSettingEditDTO) {

        SysMemberPrivilegeCardSetting cardSetting = DataTransferUtil.model(sysMemberPrivilegeCardSettingEditDTO, new SysMemberPrivilegeCardSetting());

        if (JudgeParam.isNullOrUndefined(cardSetting.getId())){

            baseMapper.insert(cardSetting);
        } else {

            SysMemberPrivilegeCardSetting memberPrivilegeCardSetting = baseMapper.selectById(cardSetting.getId());

            JudgeParam.entityIsNotNull(memberPrivilegeCardSetting, SystemMsgConstants.MEMBER_PRIVILEGE_CARD_NOT_EXIST);

            baseMapper.updateById(cardSetting);
        }
    }

    /**
     * 获取会员特权卡详情
     * @param id 会员特权卡ID
     * @return
     */
    @Override
    public SysMemberPrivilegeCardSettingVO getDetail(String id) {

        return iSysMemberPrivilegeCardSettingMapper.getDetail(id);
    }
}
