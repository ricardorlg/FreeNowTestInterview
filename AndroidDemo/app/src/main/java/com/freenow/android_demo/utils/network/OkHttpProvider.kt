package com.freenow.android_demo.utils.network

import com.freenow.android_demo.misc.Constants.SOCKET_TIMEOUT
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpProvider {

    val instance: OkHttpClient = OkHttpClient.Builder().readTimeout(30L, TimeUnit.SECONDS).build()
}