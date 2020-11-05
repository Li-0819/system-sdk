package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoEditDTO;
import com.iris.model.dto.system.SysPartTimeJobLibraryInfoListDTO;
import com.iris.model.entity.SysPartTimeJobLibraryInfo;
import com.iris.model.vo.system.SysPartTimeJobLibraryInfoVO;


/**
 * <p>
 * 职位描述素材库信息 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysPartTimeJobLibraryInfoService extends IService<SysPartTimeJobLibraryInfo> {

    /**
     * 获取职位素材库信息列表
     * @param listDTO {@link SysPartTimeJobLibraryInfoListDTO}
     * @return
     */
    PageResponseVO<SysPartTimeJobLibraryInfoVO> getList(SysPartTimeJobLibraryInfoListDTO listDTO);

    /**
     * 获取职位素材库信息详情
     * @param id 职位素材库信息ID
     * @return
     */
    SysPartTimeJobLibraryInfoVO getDetail(String id);

    /**
     * 编辑职位描述素材库信息
     * @param editDTO {@link SysPartTimeJobLibraryInfoEditDTO}
     */
    void edit(SysPartTimeJobLibraryInfoEditDTO editDTO);
}
