package com.youtubebackend.youtubebackend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    private String id;
    private String text;
    private String author;
    private Long likeCount;
    private Long dislikeCount;
}
