package com.cook.socialMedia.repositories;

import com.cook.socialMedia.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
}
