package com.youtubebackend.youtubebackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
public class Comment {
    public String getId() {
        return id;
    }

    public Comment() {
    }

    public Comment(String id, String text, String author, Long likeCount, Long dislikeCount) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @Id
    private String id;
    private String text;
    private String author;
    private Long likeCount;
    private Long dislikeCount;
}
