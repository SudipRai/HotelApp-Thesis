package com.sudip.hotelaide.response

import com.sudip.hotelaide.entity.Food
import com.sudip.hotelaide.entity.Service

data class FoodResponse (
    val message:String?=null,
    val data: Food?=null
)