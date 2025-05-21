package com.example.auth.model;

import lombok.Data;

@Data
public class ResetPasswordRequest {
    private String username;
    private String email;
    private String newPassword;
    private String confirmPassword;
    private String verificationCode;
}