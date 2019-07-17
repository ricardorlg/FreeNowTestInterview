package com.freenow.android_demo.screens

import android.widget.AdapterView
import androidx.test.espresso.DataInteraction
import com.agoda.kakao.drawer.KDrawerView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.list.KAbsListView
import com.agoda.kakao.list.KAdapterItem
import com.agoda.kakao.screen.Screen
import com.freenow.android_demo.R

class MainPageScreen : Screen<MainPageScreen>() {

    val userOptionsDrawer = KDrawerView {
        withId(R.id.drawer_layout)
        isDisplayed()
    }

    val driverSearch = KEditText {
        withId(R.id.textSearch)
    }

    val driversSuggestionsResultList = KAbsListView(
            builder = { isInstanceOf(AdapterView::class.java) },
            itemTypeBuilder = { itemType(::DriverItem) })

    class DriverItem(i: DataInteraction) : KAdapterItem<DriverItem>(i)

}

