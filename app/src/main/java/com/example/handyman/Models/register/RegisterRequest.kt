package com.example.handyman.Models.register

data class RegisterRequest(
    val email: String,
    val password: String,
    val role: Int,
    val username: String
)