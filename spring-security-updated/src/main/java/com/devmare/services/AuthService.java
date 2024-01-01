package com.devmare.services;

import com.devmare.dto.JwtAuthResponse;
import com.devmare.dto.LoginRequest;
import com.devmare.dto.RefreshTokenRequest;
import com.devmare.dto.SignUpRequest;
import com.devmare.model.User;

public interface AuthService {

    User register(SignUpRequest signUpRequest);

    JwtAuthResponse login(LoginRequest loginRequest);

    JwtAuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

