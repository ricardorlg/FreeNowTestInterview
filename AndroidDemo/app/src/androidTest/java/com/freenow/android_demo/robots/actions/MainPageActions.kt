package com.freenow.android_demo.robots.actions

import androidx.test.espresso.intent.Intents
import com.agoda.kakao.intent.KIntent
import com.freenow.android_demo.activities.MainActivity
import com.freenow.android_demo.robots.Actions
import com.freenow.android_demo.robots.NoActions
import com.freenow.android_demo.screens.MainPageScreen

class MainPageActions : Actions {
    val screen = MainPageScreen()
    fun checkUserIsOnMain(): NoActions {
        val intent = KIntent {
            hasComponent(MainActivity::class.java.name)
        }
        intent.intended(Intents.times(1))
        return NoActions
    }

    fun openUserDrawer(action: DrawerActions.() -> Actions): Actions {
        screen {
            userOptionsDrawer {
                open()
            }
        }
        return DrawerActions().action()
    }

    fun closeUserDrawer(): NoActions {
        screen {
            userOptionsDrawer {
                close()
            }
        }
        return NoActions
    }

    fun searchDriver(query: String, action: DriverSuggestionsAction.() -> Actions): Actions {
        screen {
            driverSearch {
                isDisplayed()
                typeText(query)
            }
        }
        return DriverSuggestionsAction().action()
    }
}