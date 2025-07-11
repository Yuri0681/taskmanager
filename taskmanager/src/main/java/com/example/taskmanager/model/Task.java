package com.example.taskmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entity representing a task in the task management system.
 * Each task has a title, description, due date, status, and priority.
 */
@Entity
@Getter
@Setter
public class Task {

    /** The unique identifier for the task. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The title of the task. */
    private String title;

    /** A detailed description of the task. */
    private String description;

    /** The date by which the task should be completed. */
    private LocalDate dueDate;

    /** The current status of the task. Default is PENDING. */
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    /** The priority level of the task. Default is MEDIUM. */
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;

    /**
     * Enum representing the possible statuses of a task.
     */
    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }

    /**
     * Enum representing the priority levels of a task.
     */
    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}
