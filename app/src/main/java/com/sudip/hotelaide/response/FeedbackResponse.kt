package com.sudip.hotelaide.response

import com.sudip.hotelaide.entity.Feedbackmsg

data class FeedbackResponse (
    val message:String?=null,
    val data: Feedbackmsg?=null
)