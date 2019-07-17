package com.freenow.android_demo.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.intent.Intents

@DslMarker
annotation class ActionsMarker

@ActionsMarker
interface Actions {
    fun pressBack(): Actions {
        Espresso.pressBackUnconditionally()
        Intents.release()
        return this
    }
}

object NoActions : Actions