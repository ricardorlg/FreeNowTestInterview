package com.freenow.android_demo.utils

import android.app.Activity
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.agoda.kakao.list.AbsListViewAdapterAssertions
import com.freenow.android_demo.App
import com.freenow.android_demo.dependencies.component.AppComponent
import com.freenow.android_demo.dependencies.module.SharedPrefStorageModule
import com.freenow.android_demo.matchers.DriversNameStartsWithMatcher
import it.cosenonjaviste.daggermock.DaggerMock
import java.text.SimpleDateFormat
import java.util.*

val currentActivity: Activity
    get() {
        val resumedActivity = arrayOfNulls<Activity>(1)
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val resumedActivities = ActivityLifecycleMonitorRegistry.getInstance()
                    .getActivitiesInStage(Stage.RESUMED)
            if (resumedActivities.iterator().hasNext()) {
                resumedActivity[0] = resumedActivities.iterator().next() as Activity
            } else {
                throw IllegalStateException("No Activity in stage RESUMED")
            }
        }
        return resumedActivity[0]!!
    }


fun espressoDaggerMockRule() = DaggerMock.rule<AppComponent>(SharedPrefStorageModule(app)) {
    set { component -> app.setComponent(component) }
}

fun Date.format(simpleFormat: String = "yyyy-MM-dd"): String {
    return SimpleDateFormat(simpleFormat).format(this)
}

fun String.toSimpleDate(simpleFormat: String = "yyyy-MM-dd"): Date {
    return runCatching { SimpleDateFormat("yyyy-MM-dd").parse(this) }.fold(onFailure = { Date(0) }, onSuccess = { it })
}

fun AbsListViewAdapterAssertions.allItemsStartsWith(expectedPrefix: String) {
    view.check(ViewAssertions.matches(DriversNameStartsWithMatcher.allDriversNameStartsWith(expectedPrefix)))
}
val app: App get() = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App