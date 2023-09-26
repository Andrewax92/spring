package com.cook.socialMedia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
@Data
public class UserProfile {
    @Column(nullable=true)
    private String firstName;

    @Column(nullable=true)
    private String lastName;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String phone;


}
