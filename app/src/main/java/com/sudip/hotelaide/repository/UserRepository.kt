package com.sudip.hotelaide.repository

import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.api.UserApi
import com.sudip.hotelaide.api.myApiRequest
import com.sudip.hotelaide.response.LoginResponse

class UserRepository:myApiRequest() {
    private val userApi= ServiceBuilder.buildService(UserApi::class.java)


    //login
    suspend fun checkUser(roomno:String, password:String): LoginResponse {
        return apiRequest {
            userApi.checkUser(roomno,password)
        }
    }
}