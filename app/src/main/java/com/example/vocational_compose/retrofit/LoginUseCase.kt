package com.example.vocational_compose.retrofit

import com.example.vocational_compose.data.model.user.UserLoginRequest
import com.example.vocational_compose.data.model.user.UserLoginResponse
import com.example.vocational_compose.retrofit.repository.LoginRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(

    private val repository: LoginRepository

) {
    operator fun invoke(
        userLoginRequest: UserLoginRequest
    ): Flow<Result<UserLoginResponse>> = flow {

        try {
            val process = repository.loginUserBody(userLoginRequest)

            coroutineScope {
                emit(Result.Success(process))

            }
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Result.Error(message = e.localizedMessage ?: "Error IOExcetion"))
            return@flow
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(Result.Error(message = e.localizedMessage ?: "Error HttpException"))
            return@flow
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(message = e.localizedMessage ?: "Error Exception"))
            return@flow
        }

    }

}
