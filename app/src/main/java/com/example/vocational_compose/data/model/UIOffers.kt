package com.example.vocational_compose.data.model

data class UIOffers(

    val elements: List<UIOffer>,
    val total: Long,
    val size: Long,
    val page: Long,
    val isEnabled: Boolean,
    val isCompleted: Boolean


    )