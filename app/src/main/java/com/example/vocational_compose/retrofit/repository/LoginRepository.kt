package com.example.vocational_compose.retrofit.repository

import com.example.vocational_compose.data.model.user.UserLoginRequest
import com.example.vocational_compose.data.model.user.UserLoginResponse

interface LoginRepository {
    suspend fun loginUserBody(userLoginRequest: UserLoginRequest): UserLoginResponse
}