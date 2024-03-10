package com.youtubebackend.youtubebackend.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String fullName;
    private String picture;
    private String sub;
    private List<String> subscribedToUsers;
    private List<String> subscribers;
    private List<String> videoHistory;
    private List<String> likedVideos;
    private List<String> dislikedVideos;

}
