package com.example.taskmanager.service;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Custom implementation of {@link UserDetailsService} for Spring Security authentication.
 *
 * <p>This service loads user-specific data from the {@link UserRepository}
 * and constructs a {@link UserDetails} object required for authentication.</p>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    /**
     * Constructs a new {@code CustomUserDetailsService} with the given repository.
     *
     * @param repository the user repository to load user data from
     */
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Loads the user by username and returns a {@link UserDetails} object.
     *
     * @param username the username identifying the user whose data is required
     * @return a fully populated {@link UserDetails} object
     * @throws UsernameNotFoundException if the user could not be found
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );
    }
}
