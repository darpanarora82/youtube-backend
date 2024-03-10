package com.youtubebackend.youtubebackend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "User")
public class User {
    private String id;

    public User(String id, String firstName, String lastName, String fullName, String picture, String sub, List<String> subscribedToUsers, List<String> subscribers, List<String> videoHistory, List<String> likedVideos, List<String> dislikedVideos) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.picture = picture;
        this.sub = sub;
        this.subscribedToUsers = subscribedToUsers;
        this.subscribers = subscribers;
        this.videoHistory = videoHistory;
        this.likedVideos = likedVideos;
        this.dislikedVideos = dislikedVideos;
    }

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

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public List<String> getSubscribedToUsers() {
        return subscribedToUsers;
    }

    public void setSubscribedToUsers(List<String> subscribedToUsers) {
        this.subscribedToUsers = subscribedToUsers;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    public List<String> getVideoHistory() {
        return videoHistory;
    }

    public void setVideoHistory(List<String> videoHistory) {
        this.videoHistory = videoHistory;
    }

    public List<String> getLikedVideos() {
        return likedVideos;
    }

    public void setLikedVideos(List<String> likedVideos) {
        this.likedVideos = likedVideos;
    }

    public List<String> getDislikedVideos() {
        return dislikedVideos;
    }

    public void setDislikedVideos(List<String> dislikedVideos) {
        this.dislikedVideos = dislikedVideos;
    }
}
