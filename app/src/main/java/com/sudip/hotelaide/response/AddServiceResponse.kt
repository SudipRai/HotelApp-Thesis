package com.sudip.hotelaide.response

import com.sudip.hotelaide.entity.Service

data class AddServiceResponse (
    val message:String?=null,
    val data:Service?=null
)