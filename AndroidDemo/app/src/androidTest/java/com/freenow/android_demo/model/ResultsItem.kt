package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("nat")
	val nat: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("dob")
	val dob: Dob? = null,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("registered")
	val registered: Registered,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("id")
	val id: Id? = null,

	@field:SerializedName("login")
	val login: Login? = null,

	@field:SerializedName("cell")
	val cell: String,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("picture")
	val picture: Picture
)