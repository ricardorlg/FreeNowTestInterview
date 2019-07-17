package com.freenow.android_demo.screens

import com.agoda.kakao.navigation.KNavigationView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.freenow.android_demo.R

class DrawerScreen() : Screen<DrawerScreen>() {

    val userName = KTextView {
        withId(R.id.nav_username)
    }

    val navigationMenu = KNavigationView {
        withId(R.id.nav_view)
    }
}