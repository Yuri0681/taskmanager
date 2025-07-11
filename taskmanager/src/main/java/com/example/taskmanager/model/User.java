package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a user in the task management system.
 * Each user has a unique ID, a username, and a password.
 */
@Entity
@Getter 
@Setter
@Table(name = "users") // Specifies the table name to avoid conflicts with reserved SQL keywords.
public class User {

    /** The unique identifier for the user. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The username used for login and identification. */
    private String username;

    /** The encoded password of the user. */
    private String password;
}
