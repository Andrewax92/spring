package com.cook.socialMedia.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user_table")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    //@OneToOne(mappedBy="author")
    private Long id;

    @OneToMany(mappedBy= "author")
    private List<Tweet> tweets;



    @Embedded
    private Credentials credentials;
    @Embedded
    private UserProfile userProfile;

    private Timestamp joined;

    private boolean deleted;
    @ManyToMany(mappedBy = "mentionedUsers")
    private Set<Tweet> mentionedInTweets;


    @ManyToMany
    @JoinTable(
            name = "user_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tweet_id")
    )
    private Set<Tweet> likedTweets;


    @ManyToMany
    @JoinTable(
            name = "followers_following",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<User> followers;

    @ManyToMany(mappedBy = "followers")
    private Set<User> following;


}
