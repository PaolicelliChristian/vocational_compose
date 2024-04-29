package com.example.vocational_compose.retrofit

import com.example.vocational_compose.data.model.offer.UIOffer
import kotlinx.coroutines.flow.Flow

interface OffersRepository {
    suspend fun getOffersList(): Flow<Result<List<UIOffer>>>

}