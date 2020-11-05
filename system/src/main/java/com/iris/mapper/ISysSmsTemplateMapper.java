package com.iris.mapper;

import com.iris.model.dto.system.SysMessageTemplateListDTO;
import com.iris.model.vo.system.SysMessageTemplateVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WindChaser
 */
@Mapper
public interface ISysSmsTemplateMapper {

    /**
     *  分页查询信息模版
     * @param
     * @param dto {@link SysMessageTemplateListDTO}
     * @return
     */
    List<SysMessageTemplateVO> getList(@Param("dto") SysMessageTemplateListDTO dto);

    /**
     * 获取消息模版详情
     * @param id {@link "消息模版ID"}
     * @return
     */
    SysMessageTemplateVO getDetail(@Param("id") String id);
}
