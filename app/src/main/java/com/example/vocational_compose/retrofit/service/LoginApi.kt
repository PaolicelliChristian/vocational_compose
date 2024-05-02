package com.example.vocational_compose.retrofit.service

import com.example.vocational_compose.data.model.user.UserLoginRequest
import com.example.vocational_compose.data.model.user.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {
    @Headers("Apikey: VKtYsk000kc8RXpduQpyEEmnoaGkrh")
    @POST("/auth/login")
    suspend fun loginUserBody(@Body userLoginRequest: UserLoginRequest): UserLoginResponse

}