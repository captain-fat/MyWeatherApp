package com.captainslow667.myweatherapp.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.captainslow667.myweatherapp.logic.Repository
import com.captainslow667.myweatherapp.logic.model.Place

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData){
        query -> Repository.searchPlace(query)
    }

    fun searchPlace(query:String){
        searchLiveData.value = query
    }
}