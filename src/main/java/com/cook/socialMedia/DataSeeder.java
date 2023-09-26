package com.cook.socialMedia;

import com.cook.socialMedia.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;

import java.sql.Timestamp;
import java.util.Arrays;

public class DataSeeder implements CommandLineRunner {
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        // Create and save users
        userRepository.saveAll(Arrays.asList(
                createUser("John", "Doe", "john@example.com", "user1", "password1", "123-456-7890"),
                createUser("Jane", "Smith", "jane@example.com", "user2", "password2", "987-654-3210"),
                createUser("Alice", "Johnson", "alice@example.com", "user3", "password3", "555-123-4567"),
                createUser("Bob", "Wilson", "bob@example.com", "user4", "password4", "777-987-6543")
        ));
    }

    private com.cook.socialMedia.entities.User createUser(String firstName, String lastName, String email, String username, String password, String phone) {
        com.cook.socialMedia.entities.User user = new com.cook.socialMedia.entities.User();
        user.setUserProfile(createUserProfile(firstName, lastName, email, phone));
        user.setCredentials(createCredentials(username, password));
        user.setJoined(new Timestamp(System.currentTimeMillis()));
        user.setDeleted(false);
        return user;
    }

    private com.cook.socialMedia.entities.UserProfile createUserProfile(String firstName, String lastName, String email, String phone) {
        com.cook.socialMedia.entities.UserProfile userProfile = new com.cook.socialMedia.entities.UserProfile();
        userProfile.setFirstName(firstName);
        userProfile.setLastName(lastName);
        userProfile.setEmail(email);
        userProfile.setPhone(phone);
        return userProfile;
    }


    private com.cook.socialMedia.entities.Credentials createCredentials(String username, String password) {
        com.cook.socialMedia.entities.Credentials credentials = new com.cook.socialMedia.entities.Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        return credentials;
    }


}
