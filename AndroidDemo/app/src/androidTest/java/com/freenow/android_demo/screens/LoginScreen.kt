package com.freenow.android_demo.screens

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.intent.KIntent
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KSnackbar
import com.freenow.android_demo.R
import com.freenow.android_demo.activities.AuthenticationActivity

class LoginScreen : Screen<LoginScreen>() {

    val loginIntent = KIntent {
        hasComponent(AuthenticationActivity::class.java.name)
    }

    val uerNameInput = KEditText {
        withId(R.id.edt_username)
    }

    val passwordField = KEditText {
        withId(R.id.edt_password)
    }

    val loginButton = KButton {
        withId(R.id.btn_login)
    }

    val snackbar: KSnackbar = KSnackbar()
}