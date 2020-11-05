package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingEditDTO;
import com.iris.model.dto.system.SysMemberPrivilegeCardSettingListDTO;
import com.iris.model.entity.SysMemberPrivilegeCardSetting;
import com.iris.model.vo.system.SysMemberPrivilegeCardSettingVO;

/**
 * <p>
 * 会员特权卡设置 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysMemberPrivilegeCardSettingService extends IService<SysMemberPrivilegeCardSetting> {

    /**
     * 获取会员特权卡设置列表
     * @param sysMemberPrivilegeCardSettingListDTO {@link SysMemberPrivilegeCardSettingListDTO}
     * @return
     */
    PageResponseVO<SysMemberPrivilegeCardSettingVO> getList(SysMemberPrivilegeCardSettingListDTO sysMemberPrivilegeCardSettingListDTO);

    /**
     * 校验会员特权卡分类是否重复
     * @param type 分类
     * @param id 会员特权卡ID
     * @return
     */
    boolean checkTypeRepeat(String type, String id);

    /**
     * 编辑会员特权卡
     * @param sysMemberPrivilegeCardSettingEditDTO {@link SysMemberPrivilegeCardSettingEditDTO}
     */
    void edit(SysMemberPrivilegeCardSettingEditDTO sysMemberPrivilegeCardSettingEditDTO);

    /**
     * 获取会员特权卡详情
     * @param id 会员特权卡ID
     * @return
     */
    SysMemberPrivilegeCardSettingVO getDetail(String id);
}
