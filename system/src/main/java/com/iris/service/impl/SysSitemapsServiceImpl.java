package com.iris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iris.mapper.ISysSitemapsMapper;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SitemapsEditDTO;
import com.iris.model.entity.SysSitemaps;
import com.iris.model.mapper.SysSitemapsMapper;
import com.iris.model.vo.system.SitemapsAuthVO;
import com.iris.model.vo.system.SitemapsVO;
import com.iris.service.ISysSitemapsService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysSitemapsServiceImpl extends ServiceImpl<SysSitemapsMapper, SysSitemaps> implements ISysSitemapsService {

    @Resource private ISysSitemapsMapper iSysSitemapsMapper;

    /**
     * 查询菜单管理列表
     * @return
     */
    @Override
    public PageResponseVO<SitemapsAuthVO> getAuthList() {

        return PageResponseVO.of(iSysSitemapsMapper.getAuthList(null), SitemapsAuthVO.class);
    }

    /**
     * 查询菜单管理列表
     * @return
     */
    @Override
    public PageResponseVO<SitemapsVO> getList(String parentId, Integer isPlatform) {

        return PageResponseVO.of(iSysSitemapsMapper.getList(parentId, isPlatform), SitemapsVO.class);
    }

    /**
     * 获取菜单管理详情
     * @param id 菜单ID
     * @return
     */
    @Override
    public SysSitemaps getDetail(String id) {

        return baseMapper.selectById(id);

    }

    /**
     * 校验相同parentID下是否存在相同name
     * @param id 菜单ID
     * @param parentId 父级ID
     * @param name 名称
     * @return
     */
    @Override
    public boolean checkRepeat(String id, String parentId, String name) {

        Integer integer = baseMapper.selectCount(new QueryWrapper<SysSitemaps>() {{
            eq(SystemCommonField.PARENT_ID, parentId)
                    .eq(SystemCommonField.NAME, name);

            if (!JudgeParam.isNullOrUndefined(id)) {

                ne(SystemCommonField.ID, id);
            }
        }});

        return integer > 0;
    }

    /**
     * 编辑菜单管理
     * @param sitemapsEditDTO {@link SitemapsEditDTO}
     */
    @Override
    public void edit(SitemapsEditDTO sitemapsEditDTO) {

        SysSitemaps sysSitemaps = DataTransferUtil.model(sitemapsEditDTO, new SysSitemaps());

        if (JudgeParam.isNullOrUndefined(sysSitemaps.getId())){

            baseMapper.insert(sysSitemaps);
        }else {

            JudgeParam.entityIsNotNull(baseMapper.selectById(sysSitemaps.getId()), SystemMsgConstants.SITE_MAPS_NOT_EXIST);

            iSysSitemapsMapper.updateSitemapsById(sysSitemaps);
        }
    }
}
