package com.be.drinkshop.controller;

import com.be.drinkshop.config.security.JwtTokenProvider;
import com.be.drinkshop.dto.JwtAuthenticationResponseDTO;
import com.be.drinkshop.dto.LoginRequestDTO;
import com.be.drinkshop.dto.SignupRequestDTO;
import com.be.drinkshop.dto.UserDTO;
import com.be.drinkshop.model.User;
import com.be.drinkshop.model.enums.UserRole;
import com.be.drinkshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));
        String jwt = jwtTokenProvider.generateToken(authentication);
        User user = userService.findUserByEmail(loginRequest.getEmail());
        return ResponseEntity.ok(new JwtAuthenticationResponseDTO(jwt, user.getFullName(), user.getRole()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createNewUser(@RequestBody SignupRequestDTO signupRequest) {
        User user = new User();
        user.setFullName(signupRequest.getFullName());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setRole(UserRole.USER);
        try {
            User user2 = userService.saveUser(user);
            return ResponseEntity.ok(new UserDTO(user2));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails authentication) {
        User user = userService.findUserByEmail(authentication.getUsername());
        return ResponseEntity.ok(new UserDTO(user));
    }
}
