package com.example.vocational_compose.retrofit

import com.example.vocational_compose.model.UIOffer
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://172.20.51.93:8080"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
val gson = GsonBuilder()
    .serializeNulls()
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
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