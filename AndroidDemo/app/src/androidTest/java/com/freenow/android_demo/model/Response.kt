package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class Response(

        @field:SerializedName("results")
        val results: List<ResultsItem>,

        @field:SerializedName("info")
        val info: Info
)