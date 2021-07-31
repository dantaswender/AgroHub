package br.com.agrohub.repository

import br.com.agrohub.model.Forecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    //v1/forecast.json?key=16c21abf192f4766b3722437212607&q=-7.88,-37.12&days=2&aqi=yes&alerts=yes&lang=pt
//    @GET("/v1/current.json?key=16c21abf192f4766b3722437212607&q=Portuguese&aqi=yes")
    @GET("v1/forecast.json?key=16c21abf192f4766b3722437212607&q=&days=2&aqi=yes&alerts=yes&lang")
    fun getCurrent(
        @Query("q")q: String,
        @Query("lang")lang: String
    ): Call<Forecast>
}