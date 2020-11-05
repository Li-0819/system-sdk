package com.iris.utils.attach;

import cn.hutool.core.lang.Snowflake;
import com.iris.model.vo.AttachmentInfoVO;
import com.iris.utils.common.BaseDateUtil;
import com.iris.utils.constants.SystemSpecialCode;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @Author ： Mr Liu
 * @Date ： 2019/5/11 16:58
 * @Description ： 上传附件
 */
@ConfigurationProperties(prefix = "file")
@Data
@Component
public class AttachmentUpload {

    /**
     * 文件上传的服务器物理路径
     */
    private String serverDir;

    /**
     * 客户端请求路径
     */
    private String requestDir;

    /**
     * 是否采用阿里云方式上传
     */
    private boolean isOss;

    /**
     * OSS访问地址
     */
    @Value("${aliyun.oss.access-url}")
    private String accessUrl;

    /**
     * 阿里云目录
     */
    @Value("${aliyun.oss.root-dir}")
    private String rootDir;



    @Resource private Snowflake snowflake;

    /**
     * 文件上传 - Mr Liu
     * @param multipartFile 文件
     * @param attachType 文件类型
     * @return  {@link AttachmentInfoVO}
     */
    public AttachmentInfoVO attachBaseInfo(MultipartFile multipartFile, String attachType)  {

        //获取当前年月-作为文件服务器根目录下的文件夹
        String timeForFolder = BaseDateUtil.getNowTime(SystemSpecialCode.YYYY_AND_MM);
        //文件原名
        String sourceName = multipartFile.getOriginalFilename();
        //文件上传后的名字（将原名替换为当前时间串）
        String targetName = null;
        if (sourceName != null) {
            targetName = sourceName.replace(sourceName.substring(0, sourceName.lastIndexOf(".")), snowflake.nextIdStr());
        }
        //文件上传的半路径文件夹
        String folder = timeForFolder + File.separator + attachType + File.separator + BaseDateUtil.getNowTime(SystemSpecialCode.MM_DD);
        folder = isOss ? rootDir + File.separator + folder : folder;
        //文件上传的半路径
        String halfPath = File.separator + folder + File.separator + targetName;

        //文件访问路径
        String requestPath = (isOss ? accessUrl : requestDir) + halfPath ;

        return new AttachmentInfoVO(null, sourceName, targetName, halfPath, folder, requestPath);
    }
}
