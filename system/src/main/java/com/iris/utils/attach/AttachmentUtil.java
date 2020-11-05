package com.iris.utils.attach;

import cn.hutool.core.lang.Snowflake;
import com.alibaba.fastjson.JSONObject;
import com.iris.exception.CustomException;
import com.iris.utils.attach.oss.MediaUtil;
import com.iris.utils.constants.SystemMsgConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @Author: izanagi
 * @Date: 2020-07-02 16:04
 * @Description: LocationUpload
 */
@Component
public class AttachmentUtil {

    @Resource private MediaUtil mediaUtil;
    @Resource private Snowflake snowflake;

    /**
     * 将文件上传至本地
     * @param folder 文件夹
     * @param targetName 文件名称
     * @param multipartFile 文件流
     */
    public void locationUpload(String folder, String targetName, MultipartFile multipartFile) {

        File target = new File(folder);

        //判断目标文件夹是否存在（不存在则创建）
        if(!target.exists()) {

            target.mkdirs();
        }

        File newFile = new File(folder + File.separator + targetName);
        //将文件写入目标
        try {
            multipartFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(SystemMsgConstants.ATTACHMENT_UPLOAD_ERROR);
        }
    }

    public String transcoding(String folder, String targetName, String suffix) {

        String out = null;
        JSONObject transform = mediaUtil.submitSnapshot(folder + File.separator + targetName,
                folder + File.separator + snowflake.nextIdStr() + suffix);

        if (transform.getBooleanValue("success")) {

            try {
                out = URLDecoder.decode(
                        transform.getJSONObject("job").getJSONObject("output").getJSONObject("outputFile").getString("object"), "utf-8");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return out;
    }
}
