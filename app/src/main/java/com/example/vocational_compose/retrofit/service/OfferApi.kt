package com.example.vocational_compose.retrofit.service

import com.example.vocational_compose.data.model.offer.UIOffers
import retrofit2.http.GET
import retrofit2.http.Headers

interface OfferApi {
    @Headers("Apikey: VKtYsk000kc8RXpduQpyEEmnoaGkrh")
    @GET("web/getAllOfferts")
    suspend fun getOfferList(): UIOffers

    companion object {
        const val BASE_URL_IP = "https://vt-job.it/api/"
    }

}