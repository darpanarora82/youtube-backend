package com.youtubebackend.youtubebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UploadVideoResponse {
    private String videoId;
    private String videoUrl;
}
