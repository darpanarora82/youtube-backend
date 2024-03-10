package com.youtubebackend.youtubebackend.repository;

import com.youtubebackend.youtubebackend.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
}
