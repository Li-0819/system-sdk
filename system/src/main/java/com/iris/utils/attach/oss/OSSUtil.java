package com.iris.utils.attach.oss;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author izanagi
 * @date 2020/2/25 11:02
 * @description OSSUtil
 */
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
@Component
public class OSSUtil {

//    static Logger logger = LoggerFactory.getLogger(OSSManageUtil.class);

    /**
     * 文件上传的服务器物理路径
     */
    private String endpoint;

    /**
     * 客户端请求路径
     */
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String accessUrl;

    /**
     * 阿里云文件上传
     * @param multipartFile 文件
     * @param remotePath 远程路径（doc-review/xxx）
     * @param fileName 上传后的文件名
     * @return 不带域名的
     */
    public String uploadFileFile(MultipartFile multipartFile, String remotePath, String fileName) {
        // 流转换 将MultipartFile转换为oss所需的InputStream
        // CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        // DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        InputStream fileContent = null;
//        String fileName = null;
        String remoteFilePath = null;
        try {
            fileContent = multipartFile.getInputStream();

            //获取文件名，对文件名做随机处理
//            fileName = multipartFile.getOriginalFilename();
            //这里可以修改文件的命名
//            fileName = IdUtil.createSnowflake(1, 1).nextId() + fileName.substring(fileName.lastIndexOf("."));
            // 加载配置文件，初始化OSSClient
            //  OSSConfigure ossConfigure = new OSSConfigure("/system.properties");
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 定义二级目录
            remoteFilePath = remotePath.replaceAll("\\\\", "/") + "/";
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(fileContent.available());
            objectMetadata.setContentEncoding("utf-8");
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            ossClient.putObject(bucketName, remoteFilePath+fileName , fileContent, objectMetadata);
            // 关闭OSSClient
            ossClient.shutdown();
            // 关闭io流
            fileContent.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/" + remoteFilePath + fileName;
    }

    // 本地上传
    public String uploadFileFile(String  file, String remotePath) throws Exception {
        // 流转换 将MultipartFile转换为oss所需的InputStream
        //  File filePath=new File(file);
         /*CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();*/
        InputStream fileContent =new FileInputStream(new File(file)); ;// fi.getInputStream();
        //获取文件名，对文件名做随机处理
        String fileName = file.split("/")[file.split("/").length-1];//  .getName();
        fileName = IdUtil.createSnowflake(1, 1).nextId() + fileName.substring(fileName.lastIndexOf("."));
        // 加载配置文件，初始化OSSClient
        //  OSSConfigure ossConfigure = new OSSConfigure("/system.properties");
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 定义二级目录
        String remoteFilePath = remotePath.substring(0, remotePath.length()).replaceAll("\\\\", "/") + "/";
        // 创建上传Object的Metadata
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(fileContent.available());
        objectMetadata.setContentEncoding("utf-8");
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(contentType(fileName.substring(fileName.lastIndexOf("."))));
        objectMetadata.setContentDisposition("inline;filename=" + fileName);
        // 上传文件
        System.out.print(remoteFilePath);
        ossClient.putObject(bucketName, remoteFilePath+fileName , fileContent, objectMetadata);
        // 关闭OSSClient
        ossClient.shutdown();
        // 关闭io流
        fileContent.close();
        return accessUrl + "/" + remoteFilePath + fileName;
    }

    // 下载文件
    @SuppressWarnings("unused")
    public void downloadFile(String key, String filename) throws OSSException, ClientException, IOException {
        // 初始化OSSClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        OSSObject object = ossClient.getObject(bucketName, key);
        // 获取ObjectMeta
        ObjectMetadata meta = object.getObjectMetadata();

        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();

        ObjectMetadata objectData = ossClient.getObject(new GetObjectRequest(bucketName, key),
                new File(filename));
        // 关闭数据流
        objectContent.close();
    }

    public String getUrl(String key){

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 设置URL过期时间为1小时
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName, key);
        generatePresignedUrlRequest.setExpiration(expiration);
        URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * 根据key删除OSS服务器上的文件 @Title: deleteFile @Description: @param @param
     * ossConfigure @param 配置文件实体 @param filePath 设定文件 @return void 返回类型 @throws
     */
    public void deleteFile( String filePath) {
        //  OSSConfigure ossConfigure = new OSSConfigure("/system.properties");
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(bucketName, filePath);

    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType @Version1.0
     *
     * @param FilenameExtension
     *            文件后缀
     * @return String
     */
    public static String contentType(String FilenameExtension) {
        if (FilenameExtension.equals(".BMP") || FilenameExtension.equals(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equals(".GIF") || FilenameExtension.equals(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equals(".JPEG") || FilenameExtension.equals(".jpeg") || FilenameExtension.equals(".JPG")
                || FilenameExtension.equals(".jpg") || FilenameExtension.equals(".PNG")
                || FilenameExtension.equals(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equals(".HTML") || FilenameExtension.equals(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equals(".TXT") || FilenameExtension.equals(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equals(".VSD") || FilenameExtension.equals(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equals(".PPTX") || FilenameExtension.equals(".pptx") || FilenameExtension.equals(".PPT")
                || FilenameExtension.equals(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equals(".DOCX") || FilenameExtension.equals(".docx") || FilenameExtension.equals(".DOC")
                || FilenameExtension.equals(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equals(".XML") || FilenameExtension.equals(".xml")) {
            return "text/xml";
        }
        if (FilenameExtension.equals(".apk") || FilenameExtension.equals(".APK")) {
            return "application/octet-stream";
        }
        return "text/html";
    }
}
