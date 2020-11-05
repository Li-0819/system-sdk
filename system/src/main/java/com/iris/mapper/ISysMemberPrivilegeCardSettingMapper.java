package com.iris.mapper;


import com.iris.model.dto.system.SysMemberPrivilegeCardSettingListDTO;
import com.iris.model.vo.system.SysMemberPrivilegeCardSettingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 * @createTime 2020-07-29 13:53
 * @description NAME
 */
@Mapper
public interface ISysMemberPrivilegeCardSettingMapper {

    /**
     * 获取会员特权卡列表
     * @param listDTO {@link SysMemberPrivilegeCardSettingListDTO}
     * @return
     */
    List<SysMemberPrivilegeCardSettingVO> getList(
            @Param("listDTO") SysMemberPrivilegeCardSettingListDTO listDTO);

    /**
     * 获取会员特权卡详情
     * @param id
     * @return
     */
    SysMemberPrivilegeCardSettingVO getDetail(@Param("id") String id);
}
