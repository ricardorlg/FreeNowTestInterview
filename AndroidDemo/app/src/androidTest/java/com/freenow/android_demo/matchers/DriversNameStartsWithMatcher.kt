package com.freenow.android_demo.matchers

import android.view.View
import android.widget.AdapterView
import androidx.test.espresso.matcher.BoundedMatcher
import com.freenow.android_demo.adapters.DriverAdapter
import org.hamcrest.Description

class DriversNameStartsWithMatcher(private val expectedPrefix: String) : BoundedMatcher<View, AdapterView<*>>(AdapterView::class.java) {
    override fun matchesSafely(item: AdapterView<*>): Boolean {
        val dataAdapter = item.adapter
        return if (dataAdapter is DriverAdapter) {
            val drivers = dataAdapter.allItems
            drivers.all {
                it.name.startsWith(expectedPrefix, true)
            }
        } else {
            false
        }
    }

    override fun describeTo(description: Description) {
        description.appendText("All drivers name in suggestion driversSuggestionsResultList should start with ").appendValue(expectedPrefix)
    }

    companion object{
        fun allDriversNameStartsWith(expectedPrefix: String)= DriversNameStartsWithMatcher(expectedPrefix)
    }

}