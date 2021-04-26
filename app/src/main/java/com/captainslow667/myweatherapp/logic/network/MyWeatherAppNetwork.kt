package com.captainslow667.myweatherapp.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.http.Query
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object MyWeatherAppNetwork {
    //通过ServiceCreator创造动态代理对象
    private val placeService = ServiceCreator.create(PlaceService::class.java)

    //发起城市搜索数据请求
    suspend fun searchPlace(query: String) = placeService.searchPlaces(query).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {
            continuation -> enqueue(object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if(body!= null) continuation.resume(body)
                else continuation.resumeWithException(
                    RuntimeException("response body is null")
                )

            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
        }
    }
}