package com.cook.socialMedia.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
public class HashTag {

    @Id
    @GeneratedValue
    //@OneToOne(mappedBy="id")
    private Long id;

    private String label;

    @Column(nullable= false)
    private Timestamp firstUsed;

    @Column(nullable= false)
    private Timestamp lastUsed;

    @ManyToMany(mappedBy = "hashTags")
    private Set<Tweet> tweets;

}
