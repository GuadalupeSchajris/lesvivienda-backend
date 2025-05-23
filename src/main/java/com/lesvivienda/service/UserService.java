package com.lesvivienda.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lesvivienda.dto.RegisterRequest;
import com.lesvivienda.dto.UpdateUserRequest;
import com.lesvivienda.model.User;
import com.lesvivienda.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        if (request.getRole() != null) {
            user.setRole(request.getRole().toLowerCase());
        } else {
            user.setRole("user");
        }

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public User updateUser(UUID id, UpdateUserRequest updateRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (updateRequest.getUsername() != null) {
            if (userRepository.findByUsername(updateRequest.getUsername()).isPresent()) {
                throw new RuntimeException("Username already exists");
            }
            user.setUsername(updateRequest.getUsername());
        }

        if (updateRequest.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(updateRequest.getPassword()));
        }

        if (updateRequest.getEmail() != null) {
            if (userRepository.findByEmail(updateRequest.getEmail()).isPresent()) {
                throw new RuntimeException("Email already registered");
            }
            user.setEmail(updateRequest.getEmail());
        }

        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public boolean login(String email, String rawPassword) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, rawPassword)
            );
            return authentication.isAuthenticated();
        } catch (org.springframework.security.core.AuthenticationException | IllegalArgumentException e) {
            return false;
        }
    }
}

