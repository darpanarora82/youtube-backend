package com.youtubebackend.youtubebackend.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class S3UploadDownloadService {

    @Value("${aws.accessKey}")
    private String accessKey;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;


    public static final String bucketName = "video-0-0";


    public String uploadFile(MultipartFile multipartFile) throws IOException {

       //Create Credentials using BasicAWSCredentials
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

        //Create AmazonS3 Object for the same with credentials and region
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.fromName(region))
                .build();

        //File name For Multipart File
        var fileName= multipartFile.getOriginalFilename();

        var objectMetadata = new ObjectMetadata();

        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

            PutObjectRequest putObjectResult = new PutObjectRequest(bucketName,fileName,
                    multipartFile.getInputStream(), objectMetadata);

        amazonS3.putObject(putObjectResult);
        return amazonS3.getUrl(bucketName, fileName).toString();
    }
}
