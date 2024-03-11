package com.youtubebackend.youtubebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Video")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    public String id;

    private String description;
    private String title;
    private String userId;

    private Long likes;
    private Long dislikes;

    private List<String> tags;
    private String url;
    private VideoStatus videoStatus;
    private Long viewCount;
    private String thumbnailUrl;
    private List<Comment> comments;
}

enum VideoStatus{
PUBLIC, PRIVATE, UNLISTED;
}



