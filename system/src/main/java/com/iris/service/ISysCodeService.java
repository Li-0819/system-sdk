package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysCodeEditDTO;
import com.iris.model.dto.system.SysCodeListDTO;
import com.iris.model.entity.SysCode;
import com.iris.model.vo.system.SysCodeVO;


/**
 * <p>
 * 系统代码 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysCodeService extends IService<SysCode> {

    /**
     * 查询数据字典列表
     * @param sysCodeListDTO {@link SysCodeListDTO}
     * @return {@link SysCodeVO}
     */
    PageResponseVO<SysCodeVO> getList(SysCodeListDTO sysCodeListDTO);

    /**
     * 编辑数据字典信息
     * @param sysCodeEditDTO {@link SysCodeEditDTO}
     */
    void edit(SysCodeEditDTO sysCodeEditDTO);

    /**
     * 查询数据字典详情
     * @param id 数据字典ID
     * @return {@link SysCodeVO}
     */
    SysCodeVO getDetail(String id);

    /**
     * 删除数据字典
     * @param id 数据字典ID
     */
    void delete(String id);

    /**
     * 查看名称是否重复
     * @param name 数据字典名称
     * @param type 数据字典类型
     * @param id 数据字典ID
     * @return
     */
    boolean checkNameRepeat(String name, String type, String id);

    /**
     * 查看编码是否重复
     * @param code 数据字典编码
     * @param type 数据字典类型
     * @param id 数据字典ID
     * @return
     */
    boolean checkCodeRepeat(String code, String type, String id);
}
