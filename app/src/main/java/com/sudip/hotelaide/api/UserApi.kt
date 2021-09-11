package com.sudip.hotelaide.api

import com.sudip.hotelaide.entity.*
import com.sudip.hotelaide.response.*
import retrofit2.Response
import retrofit2.http.*

interface UserApi {
    //for login
    @FormUrlEncoded
    @POST("userLogin")
    suspend fun checkUser(
        @Field("roomno") roomno: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @POST("add/service")
    suspend fun addService(
        @Header("Authorization") token:String,
        @Body addService: Service
    ): Response<AddServiceResponse>

    @POST("send/message")
    suspend fun sendMessage(
        @Header("Authorization") token:String,
        @Body send: CustomerService
    ): Response<MessageResponse>

    @POST("send/feedback")
    suspend fun sendFeedback(
        @Header("Authorization") token:String,
        @Body feedback: Feedbackmsg
    ): Response<FeedbackResponse>

    @POST("add/food")
    suspend fun foodOrder(
        @Header("Authorization") token:String,
        @Body food: Food
    ): Response<FoodResponse>

    @GET("myfood/{id}")
    suspend fun getmyfood(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ):Response<GetFoodResponse>

    @POST("checkout")
    suspend fun checkout(
        @Header("Authorization") token:String,
        @Body checkout: Checkout
    ): Response<FoodResponse>
}