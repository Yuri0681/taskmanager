package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", service.findAll());
        return "tasks";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        service.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = service.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        model.addAttribute("task", task);
        return "taskedit_form";
    }


    @PostMapping("/{id}/edit")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        task.setId(id); 
        service.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/tasks";
    }

}