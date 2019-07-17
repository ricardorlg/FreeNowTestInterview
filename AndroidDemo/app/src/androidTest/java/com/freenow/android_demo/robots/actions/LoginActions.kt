package com.freenow.android_demo.robots.actions

import androidx.test.espresso.intent.Intents
import com.freenow.android_demo.robots.Actions
import com.freenow.android_demo.robots.NoActions
import com.freenow.android_demo.screens.LoginScreen

class LoginActions : Actions {
    val screen: LoginScreen = LoginScreen()
    fun checkUserIsOnAuthentication(): NoActions {
        screen {
            loginIntent.intended(Intents.times(1))
        }
        return NoActions
    }


    fun login(userName: String, password: String): LoginActions {
        screen {
            uerNameInput {
                typeText(userName)
            }
            passwordField {
                typeText(password)

            }
            closeSoftKeyboard()
            loginButton {
                click()
            }

        }
        return this
    }

    fun checkErrorMessageIsShown(errorMessage: Int): Actions {
        screen {
            snackbar {
                isVisible()
                text {
                    hasText(errorMessage)
                }
            }
        }
        return NoActions
    }

    fun checkNoErrorIsShown(): NoActions {
        screen {
            snackbar {
                doesNotExist()
            }
        }
        return NoActions
    }

}