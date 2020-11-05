package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPositionEditDTO;
import com.iris.model.dto.system.SysPositionListDTO;
import com.iris.model.entity.SysPosition;
import com.iris.model.vo.system.SysPositionVO;

/**
 * <p>
 * 职位信息表 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysPositionService extends IService<SysPosition> {

    /**
     * 获取职位信息列表
     * @param sysPositionListDTO {@link SysPositionListDTO}
     * @return
     */
    PageResponseVO<SysPositionVO> getList(SysPositionListDTO sysPositionListDTO);

    /**
     * 校验存在重复名称与编码数据
     * @param id 职位信息ID
     * @param organizationsId 机构编码
     * @param positionName 机构名称
     * @return
     */
    boolean checkRepeat(String id, String organizationsId, String positionName);

    /**
     * 编辑职位信息
     * @param sysPositionEditDTO {@link SysPositionEditDTO}
     */
    void edit(SysPositionEditDTO sysPositionEditDTO);

    /**
     * 获取职位信息详情
     * @param id 职位信息ID
     * @return
     */
    SysPositionVO getDetail(String id);
}
