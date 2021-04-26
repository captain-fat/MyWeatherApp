package com.captainslow667.myweatherapp.logic

import androidx.lifecycle.liveData
import com.captainslow667.myweatherapp.logic.model.Place
import com.captainslow667.myweatherapp.logic.network.MyWeatherAppNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlace(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = MyWeatherAppNetwork.searchPlace(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status i ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}