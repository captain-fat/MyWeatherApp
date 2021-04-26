package com.captainslow667.myweatherapp.logic.network

import android.telecom.Call
import com.captainslow667.myweatherapp.MyWeatherApplication
import com.captainslow667.myweatherapp.logic.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 提供接口搜索城市API
 */
interface PlaceService {

    @GET("v2/place?token=${MyWeatherApplication.TOKEN}&lang-zh_CN")
    fun searchPlaces(@Query("query") query: String): retrofit2.Call<PlaceResponse>
}