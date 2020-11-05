package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysMessageTemplateMapper;
import com.iris.model.ModelForDeleteOrRecover;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMessageTemplateEditDTO;
import com.iris.model.dto.system.SysMessageTemplateListDTO;
import com.iris.model.entity.SysMessageTemplate;
import com.iris.model.mapper.SysMessageTemplateMapper;
import com.iris.model.vo.DeleteOrRecover;
import com.iris.model.vo.system.SysMessageTemplateVO;
import com.iris.service.ISysMessageTemplateService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 消息模版库 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysMessageTemplateServiceImpl extends ServiceImpl<SysMessageTemplateMapper, SysMessageTemplate> implements ISysMessageTemplateService {

    @Resource
    private ISysMessageTemplateMapper iSysMessageTemplateMapper;

    /**
     * 查询消息模版列表
     * @param sysMessageTemplateListDTO 消息模版实体
     * @return
     */
    @Override
    public PageResponseVO<SysMessageTemplateVO> getList(SysMessageTemplateListDTO sysMessageTemplateListDTO) {

        PageHelper.startPage(sysMessageTemplateListDTO.getCurrentPage(), sysMessageTemplateListDTO.getPageSize());

        List<SysMessageTemplateVO> pageList = iSysMessageTemplateMapper.getList(sysMessageTemplateListDTO);

        return PageResponseVO.of(pageList, SysMessageTemplateVO.class);

    }

    /**
     * 删除消息模版
     * @param id 消息模版ID
     */
    @Override
    public void delete(String id) {

        ModelForDeleteOrRecover modelForDeleteOrRecover = new ModelForDeleteOrRecover(id, DeleteOrRecover.DELETE);

        SysMessageTemplate sysMessageTemplate = DataTransferUtil.model(modelForDeleteOrRecover, new SysMessageTemplate());

        baseMapper.deleteById(sysMessageTemplate);
    }

    /**
     * 编辑消息模版
     * @param sysMessageTemplateEditDTO 消息模版实体
     */
    @Override
    public void edit(SysMessageTemplateEditDTO sysMessageTemplateEditDTO) {

        SysMessageTemplate sysMessageTemplate = DataTransferUtil.model(sysMessageTemplateEditDTO, new SysMessageTemplate());

        if (JudgeParam.isNullOrUndefined(sysMessageTemplate.getId())) {

            baseMapper.insert(sysMessageTemplate);
        } else {

            SysMessageTemplate selectOne = baseMapper.selectById(sysMessageTemplate.getId());

            JudgeParam.entityIsNotNull(selectOne, SystemMsgConstants.SMS_NOT_EXIST);

            baseMapper.updateById(sysMessageTemplate);
        }
    }

    /**
     * 获取消息模版详情
     * @param id {@link "消息模版ID"}
     * @return
     */
    @Override
    public SysMessageTemplateVO getDetail(String id) {

        return iSysMessageTemplateMapper.getDetail(id);
    }

    /**
     * 校验消息模版code是否重复
     * @param code 编码
     * @param id    消息模版ID
     * @return
     */
    @Override
    public boolean checkCodeRepeat(String code, String id) {

        List<SysMessageTemplate> sysMessageTemplates = baseMapper.selectList(new QueryWrapper<SysMessageTemplate>(){{
            eq(SystemCommonField.CODE, code);

            if (!JudgeParam.isNullOrUndefined(id)){

                ne(SystemCommonField.ID,id);
            }
        }});

        return sysMessageTemplates.size() > 0;
    }
}
