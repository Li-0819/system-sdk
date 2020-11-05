package com.iris.utils.attach.oss;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.mts.model.v20140618.SubmitJobsRequest;
import com.aliyuncs.mts.model.v20140618.SubmitJobsResponse;
import com.aliyuncs.mts.model.v20140618.SubmitMediaInfoJobRequest;
import com.aliyuncs.mts.model.v20140618.SubmitMediaInfoJobResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.iris.exception.CustomException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author izanagi
 * @date 2020/2/26 10:17
 * @description MediaUtil
 */
@ConfigurationProperties(prefix = "aliyun.media")
@Data
@Component
public class MediaUtil {

    /**
     * 地域ID
     */
    private String regionId;
    /**
     * AccessKey ID
     */
    private String accessKeyId;
    /**
     * AccessKey Secret
     */
    private String accessKeySecret;
    /**
     *
     */
    private String bucket;
    private String location;
    private String outputObject;
    private String outputLocation;
    private String pipelineId;
    private String templateId;

    /**
     * 提交媒体作业信息
     * @param mediaPath
     */
    public void submitMediaInfo(String mediaPath) {

        // 创建SubmitMediaInfoJob实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        SubmitMediaInfoJobRequest request = new SubmitMediaInfoJobRequest();

        try {
            // 输入文件名,路径   注意： 路径需要转码
            String ossInputObject = URLEncoder.encode(mediaPath, "utf-8");

            JSONObject inputJson = new JSONObject(3);
            // 输出Bucket
            inputJson.put("Bucket", bucket);
            // 输出Bucket所在地域
            inputJson.put("Location", location);
            // 输入文件名,路径   注意 路径需要转码
            inputJson.put("Object", ossInputObject);

            request.setInput(inputJson.toString());
            SubmitMediaInfoJobResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("input URL encode failed");
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

    /**
     * 提交媒体转码作业
     * @param mediaPath 源媒体地址（相对地址非访问地址）
     * @param outputName 转码后的文件（相对地址）
     */
    public JSONObject submitSnapshot(String mediaPath, String outputName) {
        // 创建QuerySnapshotJobList实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        SubmitJobsRequest request = new SubmitJobsRequest();
        /*
         * 开始封装参数Input、OutputBucket、OutputLocation、Outputs、PipelineId
         */
        // Input 作业输入，JSON对象，Input定义详见附录-参数详情-19
        JSONObject inputJson = new JSONObject(3);
        inputJson.put("Bucket", bucket);
        inputJson.put("Location", location);
        inputJson.put("Object", mediaPath);

        request.setInput(inputJson.toString());
        // OutputBucket输出Bucket，需在控制台中完成云资源授权。
        request.setOutputBucket(outputObject);
        // OutputLocation 输出 Bucket 所在数据中心。 默认值：oss-cn-hangzhou
        request.setOutputLocation(outputLocation);
        // Outputs由Output列表构成，JSON数组，大小上限为30。  Output的参数说明见附录 参数Output详情。
        // 此JSON字符串仅做参考请根据自身实际情况进行参数变动

        try {

            JSONArray outPutArray = new JSONArray(1);
            JSONObject outPutJson = new JSONObject(2);
            outPutJson.put("OutputObject", URLEncoder.encode(outputName, "utf-8"));
            outPutJson.put("TemplateId", templateId);
            outPutArray.add(outPutJson);

            request.setOutputs(outPutArray.toString());

            //PipelineId 管道ID :若需要异步通知，须保证此管道绑定了可用的消息主题。
            request.setPipelineId(pipelineId);

            SubmitJobsResponse response = client.getAcsResponse(request);
            // 处理返回参数

            JSONObject result = JSONObject.parseObject(new Gson().toJson(response));

            JSONArray array = result.getJSONArray("jobResultList");

            return array.getJSONObject(0);

        } catch (UnsupportedEncodingException e){
            throw new CustomException(e.getMessage());
        } catch (ServerException e) {
            throw new CustomException("ErrCode:" + e.getErrCode() + "，ErrMsg:" + e.getErrMsg());
        } catch (ClientException e) {
            throw new CustomException("ErrCode:" + e.getErrCode() + "，ErrMsg:" + e.getErrMsg());
        }
    }
}
