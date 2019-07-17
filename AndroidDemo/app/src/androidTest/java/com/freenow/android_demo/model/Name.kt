package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class Name(

	@field:SerializedName("last")
	val last: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("first")
	val first: String
)