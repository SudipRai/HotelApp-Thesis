package com.sudip.hotelaide.response

import com.sudip.hotelaide.entity.CustomerService


data class MessageResponse (
    val message:String?=null,
    val data: CustomerService?=null
)