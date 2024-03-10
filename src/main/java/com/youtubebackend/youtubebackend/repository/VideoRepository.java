package com.youtubebackend.youtubebackend.repository;

import com.youtubebackend.youtubebackend.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
