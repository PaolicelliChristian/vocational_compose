package com.example.vocational_compose.retrofit.repository

import com.example.vocational_compose.data.model.offer.UIOffer
import com.example.vocational_compose.retrofit.Result
import kotlinx.coroutines.flow.Flow

interface OffersRepository {
    suspend fun getOffersList(): Flow<Result<List<UIOffer>>>

}