package com.youtubebackend.youtubebackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.xml.stream.events.Comment;
import java.util.List;

@Document(collection = "Video")
public class Video {
    @Id
    public String id;

    public Video() {
    }

    public Video(String id, String description, String title, String userId, Long likes, Long dislikes, List<String> tags, String url, VideoStatus videoStatus, Long viewCount, String thumbnailUrl, List<Comment> comments) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.userId = userId;
        this.likes = likes;
        this.dislikes = dislikes;
        this.tags = tags;
        this.url = url;
        this.videoStatus = videoStatus;
        this.viewCount = viewCount;
        this.thumbnailUrl = thumbnailUrl;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getDislikes() {
        return dislikes;
    }

    public void setDislikes(Long dislikes) {
        this.dislikes = dislikes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VideoStatus getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(VideoStatus videoStatus) {
        this.videoStatus = videoStatus;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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



