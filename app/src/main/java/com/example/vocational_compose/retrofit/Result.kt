package com.example.vocational_compose.retrofit

sealed class Result<T>(
//    val data: T? = null,
//    val message: String? = null
) {

    class Success<T>(val data: T?) : Result<T>()
    class Error<T>(val error:T? = null, val message: String?) : Result<T>()


}