package com.example.auth.model;

import lombok.Data;

@Data
public class VerificationCodeRequest {
    private String email;
    private String purpose;  // REGISTER or RESET_PASSWORD
}