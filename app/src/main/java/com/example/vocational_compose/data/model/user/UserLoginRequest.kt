package com.example.vocational_compose.data.model.user

data class UserLoginRequest(
    val context: String,
    val email: String,
    val password: String
)