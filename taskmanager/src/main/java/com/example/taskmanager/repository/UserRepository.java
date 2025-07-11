package com.example.taskmanager.repository;

import com.example.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing {@link User} entities.
 *
 * <p>This interface provides methods to interact with the database
 * for operations related to {@link User} objects. It extends {@link JpaRepository},
 * which includes standard CRUD operations.</p>
 *
 * <p>Includes a custom method to find a user by their username.</p>
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
