package com.freenow.android_demo.screens

import com.agoda.kakao.image.KImageView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.freenow.android_demo.R

class DriverProfileScreen : Screen<DriverProfileScreen>() {

    val driverAvatarField = KImageView {
        withId(R.id.imageViewDriverAvatar)
    }

    val driverName = KTextView {
        withId(R.id.textViewDriverName)
    }

    val driverLocation = KTextView {
        withId(R.id.textViewDriverLocation)
    }

    val driverRegisteredDate = KTextView {
        withId(R.id.textViewDriverDate)
    }

    val callButton = KButton {
        withId(R.id.fab)
    }


}