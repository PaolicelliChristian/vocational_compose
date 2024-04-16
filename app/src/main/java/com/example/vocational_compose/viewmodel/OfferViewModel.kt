package com.example.vocational_compose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocational_compose.model.UIOffer
import com.example.vocational_compose.retrofit.PublicApi
import kotlinx.coroutines.launch

class OfferViewModel : ViewModel() {
    private val _offerList = mutableListOf<UIOffer>()

    var errorMessage: String by mutableStateOf("")

    val offerList: List <UIOffer>
        get() = _offerList


    private fun getOfferList() {
        viewModelScope.launch{

            val listResult = PublicApi.retrofitService.getOffer()
            //offerList = listResult
        }
    }







}