package com.iris.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.iris.mapper.ISysCodeMapper;
import com.iris.model.ModelForDeleteOrRecover;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysCodeEditDTO;
import com.iris.model.dto.system.SysCodeListDTO;
import com.iris.model.entity.SysCode;
import com.iris.model.mapper.SysCodeMapper;
import com.iris.model.vo.DeleteOrRecover;
import com.iris.model.vo.system.SysCodeVO;
import com.iris.service.ISysCodeService;
import com.iris.utils.common.JudgeParam;
import com.iris.utils.constants.SystemCommonField;
import com.iris.utils.constants.SystemMsgConstants;
import com.iris.utils.transfer.DataTransferUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统代码 服务实现类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
@Service
public class SysCodeServiceImpl extends ServiceImpl<SysCodeMapper, SysCode> implements ISysCodeService {

    @Resource private ISysCodeMapper iSysCodeMapper;

    /**
     * 查询数据字典列表·
     * @param sysCodeListDTO {@link SysCodeListDTO}
     * @return {@link SysCodeVO}
     */
    @Override
    public PageResponseVO<SysCodeVO> getList(SysCodeListDTO sysCodeListDTO) {

        PageHelper.startPage(sysCodeListDTO.getCurrentPage(), sysCodeListDTO.getPageSize());

        List<SysCodeVO> list = iSysCodeMapper.getList(sysCodeListDTO);

        return PageResponseVO.of(list, SysCodeVO.class);
    }

    /**
     * 编辑数据字典信息
     * @param sysCodeEditDTO {@link SysCodeEditDTO}
     */
    @Override
    public void edit(SysCodeEditDTO sysCodeEditDTO) {

        SysCode sysCode = DataTransferUtil.model(sysCodeEditDTO, new SysCode());

        if (JudgeParam.isNullOrUndefined(sysCodeEditDTO.getId())) {

            baseMapper.insert(sysCode);
        } else {

            SysCode selectOne = baseMapper.selectOne(
                    new QueryWrapper<SysCode>() {{ eq(SystemCommonField.ID, sysCodeEditDTO.getId());}}
            );

            JudgeParam.entityIsNotNull(selectOne, SystemMsgConstants.CODE_NOT_EXIST);

            baseMapper.updateById(sysCode);
        }
    }

    /**
     * 获取数据字典详情
     * @param id 数据字典ID
     * @return {@link SysCodeVO}
     */
    @Override
    public SysCodeVO getDetail(String id) {
        return DataTransferUtil.model(
                baseMapper.selectOne(
                        new QueryWrapper<SysCode>() {{
                            eq(SystemCommonField.ID, id);
                        }}
                ), new SysCodeVO()
        );
    }

    /**
     * 删除数据字典信息
     * @param id 数据字典ID
     */
    @Override
    public void delete(String id) {

        ModelForDeleteOrRecover modelForDeleteOrRecover = new ModelForDeleteOrRecover(id, DeleteOrRecover.DELETE);

        SysCode sysCode = DataTransferUtil.model(modelForDeleteOrRecover, new SysCode());
        baseMapper.logicDelete(sysCode);
    }

    /**
     * 查看名称是否重复
     * @param name 数据字典名称
     * @param type 数据字典类型
     * @param id 数据字典ID
     * @return
     */
    @Override
    public boolean checkNameRepeat(String name, String type, String id) {

        SysCode sysCode = baseMapper.selectOne(
                new QueryWrapper<SysCode>() {{
                    eq(SystemCommonField.NAME, name).eq(SystemCommonField.TYPE, type)
                            .ne(SystemCommonField.ID, id);
                }}
        );

        return ObjectUtil.isNotEmpty(sysCode);
    }

    /**
     * 查看编码是否重复
     * @param code 数据字典编码
     * @param type 数据字典类型
     * @param id 数据字典ID
     * @return
     */
    @Override
    public boolean checkCodeRepeat(String code, String type, String id) {

        SysCode sysCode = baseMapper.selectOne(
                new QueryWrapper<SysCode>() {{
                    eq(SystemCommonField.CODE, code).eq(SystemCommonField.TYPE, type)
                            .ne(SystemCommonField.ID, id);
                }}
        );

        return ObjectUtil.isNotEmpty(sysCode);
    }
}
