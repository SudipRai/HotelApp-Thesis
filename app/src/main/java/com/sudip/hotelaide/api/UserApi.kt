package com.sudip.hotelaide.api

import com.sudip.hotelaide.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {
    //for login
    @FormUrlEncoded
    @POST("userLogin")
    suspend fun checkUser(
        @Field("roomno") roomno: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}