package com.sudip.hotelaide.response

import com.sudip.hotelaide.entity.Food

class GetFoodResponse (
    val message:String?=null,
    val data:MutableList<Food>?=null
        )