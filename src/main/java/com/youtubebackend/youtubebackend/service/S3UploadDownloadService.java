package com.youtubebackend.youtubebackend.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class S3UploadDownloadService {

    public static final String YOUTUBE_CLONE_BACKENDSPRING = "youtube-clone-backendspring";
    @Autowired
    private AmazonS3Client amazonS3Client;

    public String uploadFile(MultipartFile multipartFile) {
        AWSCredentials credentials = new BasicAWSCredentials("AKIAU7XMQKHIFQNWPSNL", "4JbKBlJIDHyZ3pmshPcDAodvPvCrJKG8g2IL4zg4");

        //store file
        var filenameExtension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        var key = UUID.randomUUID().toString() + "." + filenameExtension;

        var objectMetadata = new ObjectMetadata();

        objectMetadata.setContentLength(multipartFile.getSize());

        try {
            PutObjectResult putObjectResult = amazonS3Client.putObject(YOUTUBE_CLONE_BACKENDSPRING, key,
                    multipartFile.getInputStream(), objectMetadata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        amazonS3Client.setObjectAcl(YOUTUBE_CLONE_BACKENDSPRING, key, CannedAccessControlList.PublicRead);
        return amazonS3Client.getResourceUrl(YOUTUBE_CLONE_BACKENDSPRING, key);
    }
}
