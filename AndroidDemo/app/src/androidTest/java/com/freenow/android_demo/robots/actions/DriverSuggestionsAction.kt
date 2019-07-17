package com.freenow.android_demo.robots.actions

import androidx.test.espresso.intent.Intents
import com.agoda.kakao.intent.KIntent
import com.freenow.android_demo.matchers.DriverNameMatcher
import com.freenow.android_demo.activities.DriverProfileActivity
import com.freenow.android_demo.utils.allItemsStartsWith
import com.freenow.android_demo.models.Driver
import com.freenow.android_demo.robots.Actions
import com.freenow.android_demo.robots.NoActions
import com.freenow.android_demo.screens.MainPageScreen

class DriverSuggestionsAction() : Actions {
    val screen = MainPageScreen()

    fun resultsShouldStartWith(expectedPrefix: String): NoActions {
        screen {
            driversSuggestionsResultList {
                inRoot { isPlatformPopup() }
                isVisible()
                allItemsStartsWith(expectedPrefix)
            }
        }
        return NoActions
    }

    fun selectDriver(driverName: String): NoActions {
        screen {
            driversSuggestionsResultList {
                inRoot { isPlatformPopup() }
                childWith<MainPageScreen.DriverItem> {
                    isInstanceOf(Driver::class.java)
                    withMatcher(DriverNameMatcher.withDriverName(driverName))
                } perform {
                    click()
                }
            }
        }
        return NoActions
    }

    fun verifyCallToDriverProfileActivity(driver: Driver): NoActions {
        screen {
            val intent = KIntent {
                hasComponent(DriverProfileActivity::class.java.name)
                hasExtra("driver", driver)
            }
            intent.intended(Intents.times(1))
        }
        return NoActions
    }

    fun resultsSizeShouldBe(expectedSize: Int): NoActions {
        screen {
            driversSuggestionsResultList {
                inRoot { isPlatformPopup() }
                isVisible()
                hasSize(expectedSize)
            }
        }
        return NoActions
    }
}
