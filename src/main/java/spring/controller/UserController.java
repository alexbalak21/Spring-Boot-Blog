package spring.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.dto.UserRegistrationDto;
import spring.model.User;
import spring.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDto registrationDto) {
        try {
            // Check if username is already taken
            if (userService.existsByUsername(registrationDto.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body("Error: Username is already taken!");
            }

            // Check if email is already in use
            if (userService.existsByEmail(registrationDto.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body("Error: Email is already in use!");
            }

            // Create new user
            User user = new User(
                    registrationDto.getUsername(),
                    registrationDto.getPassword(),
                    registrationDto.getEmail()
            );

            // Save the user
            User registeredUser = userService.registerNewUser(user);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("User registered successfully!");
                    
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while registering user: " + e.getMessage());
        }
    }
}
