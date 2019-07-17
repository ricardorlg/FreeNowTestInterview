package com.freenow.android_demo

import com.freenow.android_demo.models.User
import com.freenow.android_demo.robots.robot
import com.nhaarman.mockito_kotlin.doReturn
import org.junit.Before
import org.junit.Test

class UserLoginTests : BaseTest() {

    @Before
    fun setUp() {
        storageModule.resetUser()
    }

    @Test
    fun whenLoginWithInvalidDataShouldShowAnErrorMessage() {
        robot {
            openApp(activityRule)
            onLoginPage {
                checkUserIsOnAuthentication()
                login(invalidUserName, invalidPassword)
                checkErrorMessageIsShown(R.string.message_login_fail)
            }
        }
    }

    @Test
    fun whenLoginWithValidDataUserShouldBeInMainScreen() {
        robot {
            openApp(activityRule)
            onLoginPage {
                checkUserIsOnAuthentication()
                login(validUserName, validPassword)
                checkNoErrorIsShown()
            }
            onMainPage {
                checkUserIsOnMain()
                openUserDrawer {
                    userNameShouldBe(validUserName)
                    logOut()
                }
            }

        }
    }

    @Test
    fun whenOpeningAppWithUserInStorageUserShouldBeInMainScreen() {
        doReturn(User(validUserName, salt, sha256)).`when`(storageModule).loadUser()
        robot {
            openApp(activityRule)
            onMainPage {
                checkUserIsOnMain()
                openUserDrawer {
                    userNameShouldBe(validUserName)
                }
                closeUserDrawer()
            }
        }
    }

    @Test
    fun whenLoginWithValidDataUserAndOpenAppAgainUserShouldBeInMainScreen() {
        robot {
            openApp(activityRule)
            onLoginPage {
                checkUserIsOnAuthentication()
                login(validUserName, validPassword)
                checkNoErrorIsShown()
            }
            onMainPage {
                checkUserIsOnMain()
                openUserDrawer {
                    userNameShouldBe(validUserName)
                }
                closeUserDrawer()
                pressBack()
            }
            openApp(activityRule)
            onMainPage {
                checkUserIsOnMain()
                openUserDrawer {
                    userNameShouldBe(validUserName)
                }
            }

        }
    }

}