package com.example.vocational_compose.di

import com.example.vocational_compose.retrofit.repository.LoginRepository
import com.example.vocational_compose.retrofit.repository.LoginRepositoryImpl
import com.example.vocational_compose.retrofit.repository.OffersRepository
import com.example.vocational_compose.retrofit.repository.OffersRepositoryImpl
import com.example.vocational_compose.retrofit.service.LoginApi
import com.example.vocational_compose.retrofit.service.OfferApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun instancedOfferApi(): OfferApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(OfferApi.BASE_URL_IP)
            .client(client)
            .build()
            .create(OfferApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOfferRepository(api: OfferApi): OffersRepository {
        return OffersRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun instancedLoginApi(): LoginApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(OfferApi.BASE_URL_IP)
            .client(client)
            .build()
            .create(LoginApi::class.java)
    }

    @Provides
    @Singleton
    fun loginRepository(api: LoginApi) = LoginRepositoryImpl(api) as  LoginRepository

}