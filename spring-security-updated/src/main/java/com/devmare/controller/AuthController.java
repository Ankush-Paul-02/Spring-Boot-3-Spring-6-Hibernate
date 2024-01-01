package com.devmare.controller;

import com.devmare.dto.JwtAuthResponse;
import com.devmare.dto.LoginRequest;
import com.devmare.dto.RefreshTokenRequest;
import com.devmare.dto.SignUpRequest;
import com.devmare.model.User;
import com.devmare.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody SignUpRequest signUpRequest
    ) {
        return ResponseEntity.ok(authService.register(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refresh(
            @RequestBody RefreshTokenRequest refreshTokenRequest
    ) {
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
