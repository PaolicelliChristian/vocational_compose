package com.example.vocational_compose.retrofit

import com.example.vocational_compose.data.model.UIElements
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "http://172.20.51.93:8080"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()



/**
 * Retrofit service object for creating api calls
 */
interface OfferApiService {
    @Headers("Apikey: VKtYsk000kc8RXpduQpyEEmnoaGkrh")
    @GET("/web/getAllOfferts")
    suspend fun getOffer(): UIElements
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PublicApi {
    val retrofitService: OfferApiService by lazy {
        retrofit.create(OfferApiService::class.java)
    }
}