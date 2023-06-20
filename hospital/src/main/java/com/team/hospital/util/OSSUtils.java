package com.team.hospital.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;

import java.io.FileInputStream;

/**
 * oss文件操作的工具类
 */
public class OSSUtils {
    private final static  String endpoint = "oss-cn-hangzhou.aliyuncs.com";  //服务器节点
    private final static String accessKeyId = "LTAI5tSZC421Lmus1ng9EhJW";  //访问key
    private final static String accessKeySecret = "SW9BnPQfmBZkS2egbL3I48ZvrhMuwW";  //key对应的密钥
    private final static String bucketName = "k3501-g2"; //桶名
    /**
     * //编写上传文件的方法
     *  @param filename  上传的文件名称
     * @param fis  文件输入流
     * @return 上传文件后的访问路径
     */
    public static String upload_File(String filename,FileInputStream fis){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //2.使用OSSClient对象的方法操作对象
        //设置oss实例的访问权限：公共读
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        //ossClient.putObject("桶名","文件名称",文件对象);
        //获取源文件的输入流
        ossClient.putObject(bucketName, filename,fis);
        //3.关闭
        ossClient.shutdown();
        //4.获取图片的路径
        String path = "http://" + bucketName + "." + endpoint + "/" + filename;
        return path;
    }

}
