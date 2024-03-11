package com.youtubebackend.youtubebackend.controller;

import com.youtubebackend.youtubebackend.dto.UploadVideoResponse;
import com.youtubebackend.youtubebackend.dto.VideoDto;
import com.youtubebackend.youtubebackend.entity.Video;
import com.youtubebackend.youtubebackend.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class VideoController {
    @Autowired
    public VideoService videoService;

    @PostMapping("/upload-video")
    public UploadVideoResponse uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {

        Video video= videoService.uploadVideo(file);
        UploadVideoResponse uploadVideoResponse=new UploadVideoResponse();
        uploadVideoResponse.setVideoId(video.getId());
        uploadVideoResponse.setVideoUrl(video.getUrl());
        return uploadVideoResponse;
    }

    @PutMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editVideoDetails(@RequestBody VideoDto videoDto){
        return videoService.editVideoDetails(videoDto);
    }

    //For Uploading a thumbnail for particular video
    @PostMapping("/thumbnail")
    public String uploadThumbnail(@RequestParam("file") MultipartFile file, @RequestParam("videoId") String videoId) throws IOException {
        return videoService.uploadThumbnail(file, videoId);
    }

}
