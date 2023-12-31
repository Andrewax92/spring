package com.cook.socialMedia.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Credentials {

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;
}

