package com.artelsv.petstudyapp.di.module

import com.artelsv.petstudyapp.data.network.MoviesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val BASE_URL = "https://api.themoviedb.org/3/"
const val READ_TIME_OUT = 60L
const val CONNECT_TIME_OUT = 60L

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideMoviesService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)
}