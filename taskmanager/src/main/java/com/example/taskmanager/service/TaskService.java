package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class that provides business logic for managing {@link Task} entities.
 */
@Service
public class TaskService {

    private final TaskRepository repository;

    /**
     * Constructs a new {@code TaskService} with the given {@link TaskRepository}.
     *
     * @param repository the task repository used to perform CRUD operations
     */
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all tasks from the database.
     *
     * @return a list of all tasks
     */
    public List<Task> findAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a task by its ID.
     *
     * @param id the ID of the task
     * @return an {@link Optional} containing the task if found, or empty if not
     */
    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Saves a task to the database. If the task already exists, it will be updated.
     *
     * @param task the task to save
     * @return the saved task
     */
    public Task save(Task task) {
        return repository.save(task);
    }

    /**
     * Deletes a task by its ID.
     *
     * @param id the ID of the task to delete
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
