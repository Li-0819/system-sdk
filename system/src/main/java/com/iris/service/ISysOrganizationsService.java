package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysOrganizationsEditDTO;
import com.iris.model.dto.system.SysOrganizationsListDTO;
import com.iris.model.entity.SysOrganizations;
import com.iris.model.vo.system.SysOrganizationsListVO;


/**
 * <p>
 * 组织机构表 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysOrganizationsService extends IService<SysOrganizations> {

    /**
     * 获取组织机构列表
     * @param sysOrganizationsListDTO {@link SysOrganizationsListDTO}
     * @return
     */
    PageResponseVO<SysOrganizationsListVO> getList(SysOrganizationsListDTO sysOrganizationsListDTO);

    /**
     * 校验组织机构相同parentId下是否有重新名称或者编码
     * @param id 组织机构ID
     * @param parentId 父节点ID
     * @param code 编码
     * @param name 名称
     * @param isPlatform 是否为平台
     * @return
     */
    boolean checkRepeat(String id, String parentId, String code, String name, Integer isPlatform);

    /**
     * 编辑组织机构
     * @param sysOrganizationsEditDTO {@link SysOrganizationsEditDTO}
     */
    void edit(SysOrganizationsEditDTO sysOrganizationsEditDTO);

    /**
     * 获取组织结构详情
     * @param id ID
     * @return
     */
    SysOrganizationsListVO getDetail(String id);

    /**
     * 审核
     * @param id 机构ID
     * @param status 状态
     */
    void audit(String id, String status);
}
