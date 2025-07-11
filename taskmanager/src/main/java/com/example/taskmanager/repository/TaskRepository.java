package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Task} entities.
 * 
 * <p>This interface provides CRUD operations and query methods
 * for interacting with the Task table in the database. It extends
 * {@link JpaRepository}, which includes methods such as save, findAll,
 * findById, deleteById, and more.</p>
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}