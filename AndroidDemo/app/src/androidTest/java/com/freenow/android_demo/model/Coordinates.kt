package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class Coordinates(

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)