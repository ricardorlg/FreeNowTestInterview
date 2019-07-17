package com.freenow.android_demo.model

import com.google.gson.annotations.SerializedName

data class Timezone(

        @field:SerializedName("offset")
        val offset: String? = null,

        @field:SerializedName("description")
        val description: String? = null
)