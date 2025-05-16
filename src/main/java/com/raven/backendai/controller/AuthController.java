package com.raven.backendai.controller;

import org.springframework.web.bind.annotation.*;

import com.raven.backendai.model.ApiResponse;
import com.raven.backendai.model.LoginRequest;
import com.raven.backendai.model.LoginResponse;
import com.raven.backendai.model.RegisterRequest;
import com.raven.backendai.model.ResetPasswordRequest;
import com.raven.backendai.model.VerificationCodeRequest;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        // 模拟登录成功返回
        LoginResponse response = new LoginResponse();
        response.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...");
        response.setRefreshToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...");
        response.setUserInfo(new LoginResponse.UserInfo("dev_user", "https://avatars.githubusercontent.com/u/123456"));
        
        return new ApiResponse<>(200, "登录成功", response);
    }

    @PostMapping("/send-verification-code")
    public ApiResponse<?> sendVerificationCode(@RequestBody VerificationCodeRequest request) {
        return new ApiResponse<>(200, "验证码已发送", Map.of("expire_in", 300));
    }

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody RegisterRequest request) {
        return new ApiResponse<>(201, "注册成功", 
            Map.of("user_id", "U20250515001",
                   "access_token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."));
    }

    @PostMapping("/reset-password")
    public ApiResponse<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        return new ApiResponse<>(200, "密码已更新", null);
    }
}