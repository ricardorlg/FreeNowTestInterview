package com.freenow.android_demo.matchers

import com.freenow.android_demo.models.Driver
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

class DriverNameMatcher(private val driverName: String) : BaseMatcher<Any>() {
    override fun matches(item: Any): Boolean {
        return if (item is Driver) {
            item.name.equals(driverName, true)
        } else false
    }

    override fun describeTo(description: Description) {
        description.appendText("Driver name should be ").appendValue(driverName)
    }

    companion object {
        fun withDriverName(driverName: String): Matcher<Any> = DriverNameMatcher(driverName)
    }
}