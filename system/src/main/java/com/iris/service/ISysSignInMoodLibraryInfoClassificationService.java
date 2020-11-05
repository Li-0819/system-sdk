package com.iris.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iris.model.PageResponseVO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationEditDTO;
import com.iris.model.dto.system.SysSignInMoodLibraryInfoClassificationListDTO;
import com.iris.model.entity.SysSignInMoodLibraryInfoClassification;
import com.iris.model.vo.system.SysSignInMoodLibraryInfoClassificationVO;

/**
 * <p>
 * 签到心情图文素材库分类 服务类
 * </p>
 *
 * @author WindChaser
 * @since 2020-07-27
 */
public interface ISysSignInMoodLibraryInfoClassificationService extends IService<SysSignInMoodLibraryInfoClassification> {

    /**
     * 查询签到心情图文素材库分类列表
     * @param sysSignInMoodLibraryInfoClassificationListDTO {@link SysSignInMoodLibraryInfoClassificationListDTO}
     * @return
     */
    PageResponseVO<SysSignInMoodLibraryInfoClassificationVO> getList(SysSignInMoodLibraryInfoClassificationListDTO sysSignInMoodLibraryInfoClassificationListDTO);

    /**
     * 校验签到心情图文素材库分类重复
     * @param name 名称
     * @param code 编码
     * @param id 素材库分类ID
     * @return
     */
    boolean checkRepeat(String name, String code, String id);

    /**
     * 编辑签到心情图文素材库分类
     * @param editDTO {@link SysSignInMoodLibraryInfoClassificationEditDTO}
     */
    void edit(SysSignInMoodLibraryInfoClassificationEditDTO editDTO);

    /**
     * 签到心情图文素材库分类详情
     * @param id ID
     * @return
     */
    SysSignInMoodLibraryInfoClassificationVO getDetail(String id);
}
