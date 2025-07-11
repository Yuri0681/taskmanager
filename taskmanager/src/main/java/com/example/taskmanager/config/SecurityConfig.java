package com.example.taskmanager.config;

import com.example.taskmanager.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring Security.
 * Defines authentication and authorization rules, login and logout settings.
 */
@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    /*
     * Constructor that injects the user details service.
     */
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

     /**
     * Configures the security filter chain.
     * <ul>
     *   <li>Allows unauthenticated access to /register, /login, and /css/**</li>
     *   <li>Requires authentication for all other requests</li>
     *   <li>Sets up form login with a custom login page and a default success URL</li>
     *   <li>Configures logout to invalidate the session, delete cookies, and redirect on success</li>
     * </ul>
     *
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain bean
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/css/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/tasks", true)
                .permitAll()
            )
            .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .permitAll()
        );
        return http.build();
    }

    /**
     * Creates a DaoAuthenticationProvider bean that uses the custom user details service
     * and BCrypt password encoder for authentication.
     *
     * @return the DaoAuthenticationProvider bean
     */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    /**
     * Creates a BCryptPasswordEncoder bean for password hashing.
     *
     * @return the BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

     /**
     * Creates an AuthenticationManager bean configured with the DaoAuthenticationProvider.
     *
     * @param http the HttpSecurity object
     * @return the AuthenticationManager bean
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder.authenticationProvider(authProvider());
        return authBuilder.build();
    }


}
