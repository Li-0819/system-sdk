package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoListDTO;
import com.iris.model.entity.SysSignInMoodLibraryInfo;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoVO;

/**
 * <p>
 * 签到心情图文素材库 服务类
 * </p>
 *
 * @author izanagi
 * @since 2020-07-13
 */
public interface ISysSignInMoodLibraryInfoService extends IService<SysSignInMoodLibraryInfo> {

    /**
     *  获取签到心情图文素材库列表
     * @param sysSignInMoodLibraryInfoListDTO {@link SysSignInMoodLibraryInfoListDTO}
     * @return
     */
    PageResponseVO<SysSignInMoodLibraryInfoVO> getList(SysSignInMoodLibraryInfoListDTO sysSignInMoodLibraryInfoListDTO);

    /**
     * 校验素材库素材名称是否重复
     * @param libraryName 素材名称
     * @param id 素材库ID
     * @return
     */
    boolean checkNameRepeat(String libraryName, String id);

    /**
     * 编辑图文素材库
     * @param sysSignInMoodLibraryInfoEditDTO {@link SysSignInMoodLibraryInfoEditDTO}
     */
    void edit(SysSignInMoodLibraryInfoEditDTO sysSignInMoodLibraryInfoEditDTO);

    /**
     * 获取图文素材库详情
     * @param id 素材库ID
     * @return
     */
    SysSignInMoodLibraryInfoVO getDetail(String id);
}
