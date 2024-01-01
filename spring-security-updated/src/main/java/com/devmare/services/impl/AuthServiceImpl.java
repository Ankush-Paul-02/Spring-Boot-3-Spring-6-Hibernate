package com.devmare.services.impl;

import com.devmare.dto.JwtAuthResponse;
import com.devmare.dto.LoginRequest;
import com.devmare.dto.RefreshTokenRequest;
import com.devmare.dto.SignUpRequest;
import com.devmare.model.Role;
import com.devmare.model.User;
import com.devmare.repository.UserRepository;
import com.devmare.services.AuthService;
import com.devmare.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final JWTService jwtService;

    public User register(SignUpRequest signUpRequest) {
        User newUser = new User();
        newUser.setEmail(signUpRequest.getEmail());
        newUser.setUsername(signUpRequest.getUsername());
        newUser.setRole(Role.USER);
        newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return userRepository.save(newUser);
    }

    public JwtAuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        var currentUser = userRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow(
                        () -> new IllegalArgumentException("Invalid email or password")
                );
        var jwt = jwtService.generateToken(currentUser);
        var refreshJwt = jwtService.generateRefreshToken(currentUser, new HashMap<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshJwt);
        return jwtAuthResponse;
    }

    public JwtAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
            var jwt = jwtService.generateToken(user);

            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
            jwtAuthResponse.setToken(jwt);
            jwtAuthResponse.setRefreshToken(refreshTokenRequest.getToken());
            return jwtAuthResponse;
        }
        return null;
    }
}
