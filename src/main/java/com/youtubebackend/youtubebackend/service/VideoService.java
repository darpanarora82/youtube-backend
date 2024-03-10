package com.youtubebackend.youtubebackend.service;

import com.youtubebackend.youtubebackend.entity.Video;
import com.youtubebackend.youtubebackend.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class VideoService {
    @Autowired
    public S3UploadDownloadService s3Service;
    @Autowired
    public VideoRepository videoRepository;

    public Video uploadVideo(MultipartFile multipartFile) throws IOException {
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setUrl(videoUrl);
        return videoRepository.save(video);
    }
}
