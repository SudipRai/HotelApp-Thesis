package com.sudip.hotelaide.repository

import com.sudip.hotelaide.api.ServiceBuilder
import com.sudip.hotelaide.api.UserApi
import com.sudip.hotelaide.api.myApiRequest
import com.sudip.hotelaide.entity.*
import com.sudip.hotelaide.response.*

class UserRepository:myApiRequest() {
    private val userApi= ServiceBuilder.buildService(UserApi::class.java)


    //login
    suspend fun checkUser(roomno:String, password:String): LoginResponse {
        return apiRequest {
            userApi.checkUser(roomno,password)
        }
    }

    suspend fun Addservice(addService: Service): AddServiceResponse {
        return apiRequest {
            userApi.addService(ServiceBuilder.token!!,addService)
        }
    }

    suspend fun sendMessage(send: CustomerService): MessageResponse {
        return apiRequest {
            userApi.sendMessage(ServiceBuilder.token!!,send)
        }
    }
    suspend fun sendFeedback(feedback: Feedbackmsg): FeedbackResponse {
        return apiRequest {
            userApi.sendFeedback(ServiceBuilder.token!!,feedback)
        }
    }
    suspend fun foodOrder(food: Food): FoodResponse {
        return apiRequest {
            userApi.foodOrder(ServiceBuilder.token!!,food)
        }
    }

    suspend fun checkout(checkout: Checkout): FoodResponse {
        return apiRequest {
            userApi.checkout(ServiceBuilder.token!!,checkout)
        }
    }


    suspend fun getmyFood(id:String): GetFoodResponse {
        return apiRequest {
            userApi.getmyfood(ServiceBuilder.token!!,id)
        }
    }
}