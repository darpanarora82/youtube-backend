package com.youtubebackend.youtubebackend.service;

import com.youtubebackend.youtubebackend.dto.VideoDto;
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

    public VideoDto editVideoDetails(VideoDto videoDto) {

        //Find the video by id
       Video savedVideo= videoRepository.findById(videoDto.getId()).orElseThrow(()-> new IllegalArgumentException("Cannot Find Video by id "+ videoDto.getId()));

        //Map to video DTO Fields
        savedVideo.setTitle(videoDto.getTitle());
        savedVideo.setDescription(videoDto.getDescription());
        savedVideo.setTags(videoDto.getTags());
        savedVideo.setThumbnailUrl(videoDto.getThumbnailUrl());
        savedVideo.setVideoStatus(videoDto.getVideoStatus());

        //save video to db
        videoRepository.save(savedVideo);
        return videoDto;
    }

    public String uploadThumbnail(MultipartFile file, String videoId) throws IOException {
        Video video= getVideoDetailsById(videoId);
        String thumbnailUrl = s3Service.uploadFile(file);
        video.setThumbnailUrl(thumbnailUrl);
        videoRepository.save(video);
        return thumbnailUrl;
    }

    Video getVideoDetailsById(String videoId)
    {
        return videoRepository.findById(videoId).orElseThrow(()-> new IllegalArgumentException("Video Can't be found"));
    }
}
