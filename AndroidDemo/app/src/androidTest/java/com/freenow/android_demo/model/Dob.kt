package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class Dob(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("age")
	val age: Int? = null
)