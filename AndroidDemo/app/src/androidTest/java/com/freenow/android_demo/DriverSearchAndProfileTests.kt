package com.freenow.android_demo

import com.freenow.android_demo.model.Response
import com.freenow.android_demo.models.Driver
import com.freenow.android_demo.models.User
import com.freenow.android_demo.robots.robot
import com.freenow.android_demo.utils.toSimpleDate
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test


class DriverSearchAndProfileTests : BaseTest() {

    private val expectedDrivers = mutableListOf<Driver>()
    private val fetchDriversUrl = "https://randomuser.me/api/?results=256&seed=23f8827e04239990"
    private val searchQuery = "sa"

    @Before
    fun setUp() {

        fetchDriversUrl.httpGet()
                .header("Content-Type" to "application/json")
                .responseObject<Response>().third
                .fold(
                        success = {
                            val allDrivers = it.results.map { item ->
                                val name = "${item.name.first.capitalize()} ${item.name.last.capitalize()}"
                                val phone = item.cell
                                val avatar = item.picture.large.orEmpty()
                                val street = item.location.street.orEmpty()
                                val registeredDate = item.registered.date.toSimpleDate()
                                Driver(name, phone, avatar, street, registeredDate)
                            }
                            expectedDrivers.addAll(allDrivers.filter { driver -> driver.name.startsWith(searchQuery, true) })
                        }, failure = {
                    throw Exception("Error fetching drivers information", it)
                })

        doReturn(User(validUserName, salt, sha256))
                .whenever(storageModule)
                .loadUser()
    }

    @Test
    fun whenSearchingForDriverResultsNamesShouldStartsWith() {
        robot {
            openApp(activityRule)
            onMainPage {
                checkUserIsOnMain()
                searchDriver(searchQuery) {
                    resultsSizeShouldBe(expectedDrivers.size)
                    resultsShouldStartWith(searchQuery)
                }
            }
        }
    }

    @Test
    fun whenOpeningResultUsingName() {
        val expectedDriver = expectedDrivers[1]
        robot {
            openApp(activityRule)
            onMainPage {
                checkUserIsOnMain()
                searchDriver(searchQuery) {
                    selectDriver(expectedDriver.name)
                    verifyCallToDriverProfileActivity(expectedDriver)
                }
            }
            onDriverPage {
                verifyProfileInformation(expectedDriver)
            }

        }
    }

    @Test
    fun whenClickOnCallButton() {
        val expectedDriver = expectedDrivers[1]
        robot {
            openApp(activityRule)
            onMainPage {
                checkUserIsOnMain()
                searchDriver(searchQuery) {
                    selectDriver(expectedDriver.name)
                }
            }
            onDriverPage {
                clickOnCallButton()
                verifyCallActivityIsLaunched("tel:${expectedDriver.phone}")
            }
        }
    }
}