package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysActionEditDTO;
import com.iris.model.dto.system.SysActionListDTO;
import com.iris.model.entity.SysAction;
import com.iris.model.vo.system.SysActionVO;


/**
 * <p>
 * 功能管理 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysActionService extends IService<SysAction> {

    /**
     * 获取功能管理列表
     * @param sysActionListDTO {@link SysActionListDTO}
     * @return
     */
    PageResponseVO<SysActionVO> getList(SysActionListDTO sysActionListDTO);

    /**
     * 编辑功能管理
     * @param sysActionEditDTO {@link SysActionEditDTO}
     */
    void edit(SysActionEditDTO sysActionEditDTO);

    /**
     * 获取功能管理详情
     * @param id
     * @return
     */
    SysActionVO getDetail(String id);

    /**
     * 校验功能管理key是否重复
     * @param key
     * @param id
     * @return
     */
    boolean checkKeyRepeat(String key, String id);
}
