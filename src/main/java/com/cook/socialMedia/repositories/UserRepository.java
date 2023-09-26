package com.cook.socialMedia.repositories;

import com.cook.socialMedia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
