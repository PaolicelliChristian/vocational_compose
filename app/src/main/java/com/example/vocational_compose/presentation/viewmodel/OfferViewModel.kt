package com.example.vocational_compose.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocational_compose.data.model.UIOffer
import com.example.vocational_compose.retrofit.PublicApi
import kotlinx.coroutines.launch

class OfferViewModel : ViewModel() {

    private val _offerList = mutableListOf<UIOffer>()

//    private val _offerList = MutableLiveData<UIElements>()

    private var errorMessage: String by mutableStateOf("")
    val offerList: List<UIOffer> get() = _offerList

    init {
        getOfferList()
    }

    private fun getOfferList() {
        viewModelScope.launch {
            val listResult = PublicApi.retrofitService.getOffer().offers
            try {
                _offerList.addAll(listResult)
//                _offerList.value?.offers
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }

}