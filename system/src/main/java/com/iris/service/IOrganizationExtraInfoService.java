package com.iris.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.organization.OrganizationExtraInfoEditDTO;
import com.iris.model.dto.organization.OrganizationExtraInfoListDTO;
import com.iris.model.entity.OrganizationExtraInfo;
import com.iris.model.vo.organization.OrganizationExtraInfoDetailVO;
import com.iris.model.vo.organization.OrganizationExtraInfoListVO;

/**
 * <p>
 * 机构附属信息 服务类
 * </p>
 *
 * @author amaterasu
 * @since 2020-09-18
 */
public interface IOrganizationExtraInfoService extends IService<OrganizationExtraInfo> {

    /**
     * 获取机构信息列表
     * @param organizationExtraInfoListDTO {@link OrganizationExtraInfoListDTO}
     * @return
     */
    PageResponseVO<OrganizationExtraInfoListVO> getList(OrganizationExtraInfoListDTO organizationExtraInfoListDTO);

    /**
     * 获取机构信息详情
     * @param id 机构信息ID
     * @return
     */
    OrganizationExtraInfoDetailVO getDetail(String id);

    /**
     * 编辑机构信息
     * @param organizationExtraInfoEditDTO {@link OrganizationExtraInfoEditDTO}
     */
    void edit(OrganizationExtraInfoEditDTO organizationExtraInfoEditDTO);

    /**
     * 审核
     * @param id 机构ID
     * @param status 状态
     */
    void audit(String id, String status);

    /**
     * 校验编辑参数
     * @param id 机构信息ID
     * @param unifiedCreditCode 统一信用代码
     * @return
     */
    boolean checkRepeat(String id,String unifiedCreditCode);
}
