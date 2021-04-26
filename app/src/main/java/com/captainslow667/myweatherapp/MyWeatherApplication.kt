package com.captainslow667.myweatherapp

import android.app.Application
import android.content.Context


/**
 * 提供全局获取context方式
 */
class MyWeatherApplication : Application(){

    companion object{
        lateinit var context: Context
        const val TOKEN = "y0ZB6CEsCPTrurBx"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }
}