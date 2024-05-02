package com.example.vocational_compose.data.model.user

data class UserLoginResponse(
    val access_token: String = "",
    val email: String = "",
    val expires_at: Long = -1,
    val firstName: String = "",
    val id: String = "",
    val isCompleted: Boolean = false,
    val lastName: String = "",
    val refresh_token: String = "",
    val role: String = "",
)