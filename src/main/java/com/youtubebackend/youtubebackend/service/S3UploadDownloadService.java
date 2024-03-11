package com.youtubebackend.youtubebackend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.youtubebackend.youtubebackend.config.AwsS3Configuration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class S3UploadDownloadService {
    @Autowired
    public AwsS3Configuration amazonS3Configuration;
    public static final String bucketName = "video-0-0";

    public String uploadFile(MultipartFile multipartFile) throws IOException {


        var key= UUID.randomUUID().toString()+"."+multipartFile.getOriginalFilename();

        //File name For Multipart File
        var fileName = multipartFile.getOriginalFilename();

        //For Object Data to e added in putObject in AWS
        var objectMetadata = new ObjectMetadata();

        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        PutObjectRequest putObjectResult = new PutObjectRequest(bucketName, key,
                multipartFile.getInputStream(), objectMetadata);

        AmazonS3 amazonS3 = amazonS3Configuration.amazonS3();
        amazonS3.putObject(putObjectResult);
        return amazonS3.getUrl(bucketName, fileName).toString();
    }
}
