package com.cook.socialMedia.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;


    @ManyToMany
    @JoinTable(
            name = "tweet_hashtags",
            joinColumns = @JoinColumn(name = "tweet_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<HashTag> hashTags;

    @ManyToMany(mappedBy = "likedTweets")
    private Set<User> userLikes;

    @ManyToMany
    @JoinTable(
            name = "user_mentions",
            joinColumns = @JoinColumn(name = "tweet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> mentionedUsers;


    @ManyToOne
    @JoinColumn(name="author")
    private User author;

    @Column(nullable= false)
    private Timestamp posted;

    private boolean deleted;

    private String content;


    @ManyToOne
    @JoinColumn(name="in_reply_to_id")
    private Tweet inReplyTo;

    @ManyToOne
    @JoinColumn(name="repost_of_id")
    private Tweet repostOf;

}
