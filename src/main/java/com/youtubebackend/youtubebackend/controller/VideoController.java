package com.youtubebackend.youtubebackend.controller;

import com.youtubebackend.youtubebackend.entity.Video;
import com.youtubebackend.youtubebackend.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class VideoController {
    @Autowired
    public VideoService videoService;

    @PostMapping("/upload-video")
    public Video uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        return videoService.uploadVideo(file);
    }
}
