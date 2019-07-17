package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Registered(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("age")
	val age: Int? = null
)