package com.freenow.android_demo.robots

import androidx.test.espresso.intent.Intents
import androidx.test.rule.ActivityTestRule
import com.freenow.android_demo.robots.actions.DriverProfileActions
import com.freenow.android_demo.robots.actions.LoginActions
import com.freenow.android_demo.robots.actions.MainPageActions

class Robot : Actions {
    fun openApp(rule: ActivityTestRule<*>): NoActions {
        Intents.init()
        rule.launchActivity(null)
        return NoActions
    }

    fun onLoginPage(action: LoginActions.() -> Actions) = LoginActions().action()
    fun onMainPage(action: MainPageActions.() -> Actions) = MainPageActions().action()
    fun onDriverPage(action: DriverProfileActions.() -> Actions) = DriverProfileActions().action()
}

fun robot(action: Robot.() -> Actions) = Robot().action()

