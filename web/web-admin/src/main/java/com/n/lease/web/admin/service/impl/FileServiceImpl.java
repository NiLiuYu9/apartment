package com.n.lease.web.admin.service.impl;

import com.n.lease.common.minio.MinioProperties;
import com.n.lease.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private MinioProperties minioProperties;

    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        //判读minio中桶是否存在，不存在则创建
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
            if (!bucketExists) {
                //创建桶
                minioClient.makeBucket(
                        MakeBucketArgs.builder().bucket(minioProperties.getBucketName())
                                .build());
                //设置桶的权限
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(minioProperties.getBucketName())
                        .config(createBucketPolicyConfig(minioProperties.getBucketName()))
                        .build());
            }
            //                 日期+唯一标识符+文件名
            String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) +
                    "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            //将流中的数据上传
            minioClient.putObject(PutObjectArgs.builder().bucket(minioProperties.getBucketName())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .object(filename)
//                    提供文件类型名，让浏览器可以正确解析而不是下载
                    .contentType(file.getContentType())
                    .build());
//               返回拼接的url            网址
        return String.join("/",minioProperties.getEndpoint(),minioProperties.getBucketName(),filename);
    }

    //设置桶的权限，允许所有人读，默认只允许自己写
    private String createBucketPolicyConfig(String bucketName) {

        return """
                {
                  "Statement" : [ {
                    "Action" : "s3:GetObject",
                    "Effect" : "Allow",
                    "Principal" : "*",
                    "Resource" : "arn:aws:s3:::%s/*"
                  } ],
                  "Version" : "2012-10-17"
                }
                """.formatted(bucketName);
    }
}
