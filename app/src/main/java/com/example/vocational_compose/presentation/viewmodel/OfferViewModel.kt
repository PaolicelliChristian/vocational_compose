package com.example.vocational_compose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocational_compose.data.model.offer.UIOffer
import com.example.vocational_compose.retrofit.Result
import com.example.vocational_compose.retrofit.repository.OffersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(
    private val offersRepository: OffersRepository
) : ViewModel() {


    private val _offers = MutableStateFlow<List<UIOffer>>(emptyList())
    val products: StateFlow<List<UIOffer>> = _offers

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        getOffers()
    }

    private fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
            offersRepository.getOffersList().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }

                    is Result.Success -> {
                        result.data?.let { offers ->
                            _offers.update { offers }
                        }
                    }
                }
            }
        }
    }

}