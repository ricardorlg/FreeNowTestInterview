package com.freenow.android_demo.robots.actions

import com.freenow.android_demo.R
import com.freenow.android_demo.robots.Actions
import com.freenow.android_demo.robots.NoActions
import com.freenow.android_demo.screens.DrawerScreen

class DrawerActions() : Actions {
    val screen = DrawerScreen()
    fun userNameShouldBe(expectedUserName: String): NoActions {
        screen {
            userName {
                hasText(expectedUserName)
            }
        }
        return NoActions
    }

    fun logOut(): NoActions {
        screen {
            navigationMenu {
                navigateTo(R.id.nav_logout)
            }
        }

        return NoActions
    }
}