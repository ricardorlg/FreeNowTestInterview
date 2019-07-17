package com.freenow.android_demo.robots.actions

import android.content.Intent
import androidx.test.espresso.intent.Intents
import com.agoda.kakao.intent.KIntent
import com.freenow.android_demo.utils.format
import com.freenow.android_demo.models.Driver
import com.freenow.android_demo.robots.Actions
import com.freenow.android_demo.robots.NoActions
import com.freenow.android_demo.screens.DriverProfileScreen

class DriverProfileActions : Actions {
    val screen = DriverProfileScreen()
    fun verifyProfileInformation(expectedDriver: Driver): NoActions {
        screen {
            driverAvatarField {
                isVisible()
                isDisplayed()
            }
            driverName {
                isDisplayed()
                hasText(expectedDriver.name)
            }
            driverLocation {
                isDisplayed()
                hasText(expectedDriver.location)
            }
            driverRegisteredDate {
                isDisplayed()
                hasText(expectedDriver.registeredDate.format())
            }
        }
        return NoActions
    }

    fun clickOnCallButton(): NoActions {
        screen {
            callButton {
                click()
            }
        }
        return NoActions
    }

    fun verifyCallActivityIsLaunched(expectedData: String): NoActions {
        screen {
            val intent = KIntent {
                hasAction(Intent.ACTION_DIAL)
                hasData(expectedData)
            }
            intent.intended(Intents.times(1))
        }
        return NoActions
    }
}