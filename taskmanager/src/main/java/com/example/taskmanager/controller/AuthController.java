package com.example.taskmanager.controller;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that handles authentication-related web requests,
 * including login and user registration.
 */
@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor to inject UserRepository and PasswordEncoder dependencies.
     *
     * @param userRepository the repository to manage User entities
     * @param passwordEncoder the encoder used for password hashing
     */
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Handles GET requests to the login page.
     *
     * @return the logical view name for the login page
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Displays the user registration form.
     * Adds an empty User object to the model for form binding.
     *
     * @param model the model to pass attributes to the view
     * @return the logical view name for the registration page
     */
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Handles the user registration form submission.
     * Encodes the user's password before saving it to the database.
     * Redirects to the login page with a query parameter indicating successful registration.
     *
     * @param user the User object bound from the registration form
     * @return a redirect URL to the login page with a registration success indicator
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login?registered";
    }
}
