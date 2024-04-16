package com.example.vocational_compose.retrofit

import com.example.vocational_compose.model.UIOffer
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://localhost:8080"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


/**
 * Retrofit service object for creating api calls
 */
interface OfferApiService {
    @GET("/web/getAllOfferts")
    suspend fun getOffer(): List<UIOffer>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object PublicApi {
    val retrofitService: OfferApiService by lazy {
        retrofit.create(OfferApiService::class.java)
    }
}