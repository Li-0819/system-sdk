package com.iris.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iris.model.entity.SysAttachInfo;
import com.iris.model.vo.system.SysAttachInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: izanagi
 * @Date: 2020-07-01 17:23
 * @Description: AttachmentMapper
 */
@Mapper
public interface AttachmentMapper extends BaseMapper<SysAttachInfo> {

    /**
     * 根据关联ID获取附件
     * @param refId 关联ID
     * @return
     */
    List<SysAttachInfoVO> getAttachesByRefId(@Param("refId") String refId);
}
