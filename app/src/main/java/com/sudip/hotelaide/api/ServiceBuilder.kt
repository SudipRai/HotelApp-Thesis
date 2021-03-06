package com.sudip.hotelaide.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    //private const val BASE_URL="http://10.0.2.2:90/"
    private const val BASE_URL="http://192.168.1.13:90/"
     //private const val BASE_URL="http://localhost:90/"
    var token:String?=null
    var userID:String?=null
    var roomno:String?=null
    var role:String?=null
    var fullname:String?=null
    private val okHttp= OkHttpClient.Builder()
    private val retrofitBuilder= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
    private val retrofit= retrofitBuilder.build()
    fun<T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }
    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
    }

}