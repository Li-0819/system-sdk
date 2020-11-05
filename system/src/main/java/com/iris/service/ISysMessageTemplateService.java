package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMessageTemplateEditDTO;
import com.iris.model.dto.system.SysMessageTemplateListDTO;
import com.iris.model.entity.SysMessageTemplate;
import com.iris.model.vo.system.SysMessageTemplateVO;

/**
 * <p>
 * 消息模版库 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysMessageTemplateService extends IService<SysMessageTemplate> {

    /**
     * 分页查询消息模版库
     * @param sysMessageTemplateListDTO {@link SysMessageTemplateEditDTO}
     * @return
     */
    PageResponseVO<SysMessageTemplateVO> getList(SysMessageTemplateListDTO sysMessageTemplateListDTO);

    /**
     * 删除消息模版
     * @param id {@link "消息模版ID"}
     */
    void delete(String id);

    /**
     * 编辑消息模版
     * @param sysMessageTemplateEditDTO {@link SysMessageTemplateEditDTO}
     */
    void edit(SysMessageTemplateEditDTO sysMessageTemplateEditDTO);

    /**
     * 获取消息模版详情
     * @param id {@link "消息模版ID"}
     * @return
     */
    SysMessageTemplateVO getDetail(String id);

    /**
     * 校验消息模版code是否重复
     * @param code 编码
     * @param id    消息模版ID
     * @return
     */
    boolean checkCodeRepeat(String code, String id);
}
