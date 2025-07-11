package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling web requests related to task management.
 * Provides functionality for listing, creating, editing, and deleting tasks.
 */
@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    /**
     * Constructs the TaskController with a TaskService dependency.
     *
     * @param service the service layer used for task operations
     */
    public TaskController(TaskService service) {
        this.service = service;
    }

    /**
     * Displays a list of all tasks.
     *
     * @param model the model to pass task list to the view
     * @return the name of the view displaying tasks
     */
    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "tasks";
    }

    /**
     * Displays the form for creating a new task.
     *
     * @param model the model to pass a new Task object to the view
     * @return the name of the view displaying the task creation form
     */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }

    /**
     * Handles submission of a new task.
     *
     * @param task the task submitted from the form
     * @return a redirect to the task list view
     */
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        service.save(task);
        return "redirect:/tasks";
    }

    /**
     * Displays the form for editing an existing task.
     *
     * @param id the ID of the task to edit
     * @param model the model to pass the task to the view
     * @return the name of the view displaying the task edit form
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = service.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        model.addAttribute("task", task);
        return "taskedit_form";
    }

    /**
     * Handles submission of the edited task.
     *
     * @param id the ID of the task being updated
     * @param task the updated task object
     * @return a redirect to the task list view
     */
    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        task.setId(id); 
        service.save(task);
        return "redirect:/tasks";
    }

    /**
     * Handles deletion of a task.
     *
     * @param id the ID of the task to delete
     * @return a redirect to the task list view
     */
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/tasks";
    }

}