package com.jobportal.backend.controller;

import com.jobportal.backend.dto.UserCreateRequest;
import com.jobportal.backend.dto.UserResponse;
import com.jobportal.backend.dto.WelcomeResponse;
import com.jobportal.backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/health")
    public String health() {
        return "Job portal backend is running";
    }

    @GetMapping("/welcome")
    public WelcomeResponse welcome() {
        return new WelcomeResponse(
                "welcome to job portal backend",
                LocalDateTime.now().toString()
        );
    }

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Page<UserResponse> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getAllUsers(page,size,sortBy);
    }
}

