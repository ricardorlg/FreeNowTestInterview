package com.freenow.android_demo

import androidx.test.espresso.intent.Intents
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.freenow.android_demo.activities.MainActivity
import com.freenow.android_demo.utils.OkHttpIdlingResourceRule
import com.freenow.android_demo.utils.app
import com.freenow.android_demo.utils.espressoDaggerMockRule
import com.freenow.android_demo.utils.storage.SharedPrefStorage
import com.nhaarman.mockito_kotlin.spy
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

open class BaseTest {
    //rules
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)
    @get:Rule
    val okHttpIdlingResourceRule = OkHttpIdlingResourceRule()
    @get:Rule
    val rule = espressoDaggerMockRule()
    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    protected val storageModule: SharedPrefStorage = spy(SharedPrefStorage(app))
    protected val validUserName = "crazydog335"
    protected val validPassword = "venture"
    protected val invalidUserName = "invaliduser"
    protected val invalidPassword = "invali"
    protected val salt = "wp3zuBv7"
    protected val sha256 = "9726ae7ce314e547ac606efc5afb1070439097903333de7c5050753d5435d72f"

    @After
    fun tearDown() {
        Intents.release()
    }
}