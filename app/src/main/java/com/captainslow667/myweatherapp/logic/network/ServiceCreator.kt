package com.captainslow667.myweatherapp.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit构建器
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com"

    //retrofit构建器
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(ServiceClass: Class<T>) :T = retrofit.create(ServiceClass)

    inline fun <reified T> create() :T = create(T::class.java)

}