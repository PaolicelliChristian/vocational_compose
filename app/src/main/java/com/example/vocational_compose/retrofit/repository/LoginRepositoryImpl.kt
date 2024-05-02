package com.example.vocational_compose.retrofit.repository

import com.example.vocational_compose.data.model.user.UserLoginRequest
import com.example.vocational_compose.data.model.user.UserLoginResponse
import com.example.vocational_compose.retrofit.service.LoginApi
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val loginApi: LoginApi
) : LoginRepository {
    override suspend fun loginUserBody(userLoginRequest: UserLoginRequest): UserLoginResponse {
        return loginApi.loginUserBody(userLoginRequest)
    }


}