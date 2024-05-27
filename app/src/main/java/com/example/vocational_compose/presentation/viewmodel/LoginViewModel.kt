package com.example.vocational_compose.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocational_compose.data.model.user.UserLoginRequest
import com.example.vocational_compose.data.model.user.UserLoginResponse
import com.example.vocational_compose.retrofit.LoginUseCase
import com.example.vocational_compose.retrofit.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    @ApplicationContext val appContext: Context
) : ViewModel() {

    private val _state = MutableLiveData<UserLoginResponse>()
    val state: LiveData<UserLoginResponse> get() = _state

    private var job: Job? = null

    fun getUserLogin(email: String, password: String, user: String) {

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            loginUseCase(
                UserLoginRequest(user, email, password)
            ).onEach { result ->

                when (result) {

                    is Result.Success -> {

                        result.data?.let {
                            val response = UserLoginResponse(
                                result.data.access_token,
                                result.data.email,
                                result.data.expires_at,
                                result.data.firstName,
                                result.data.id,
                                result.data.isCompleted,
                                result.data.lastName,
                                result.data.refresh_token,
                                result.data.role
                            )
                            _state.value = response
                        }

                    }

                    is Result.Error -> {
                        delay(200)
                        result.message ?: "An unexpected error occurred"
                    }
                }

            }.launchIn(viewModelScope)

        }

    }

}