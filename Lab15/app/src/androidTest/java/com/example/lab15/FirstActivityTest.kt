package com.example.lab15

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FisrtActivityTest {

    @get:Rule
    val activity = ActivityScenarioRule(FirstActivity::class.java)

    @Test
    fun testBtn1ToastButtonDisplayed() {
        onView(withId(R.id.button_toast)).check(matches(isDisplayed()))
    }

    @Test
    fun testBtn2LogButtonDisplayed() {
        onView(withId(R.id.button_log)).check(matches(isDisplayed()))
    }

    @Test
    fun testBtn1ClickDoesNotCrash() {
        onView(withId(R.id.button_toast)).perform(click())
    }

    @Test
    fun testBtn2ClickDoesNotCrash() {
        onView(withId(R.id.button_log)).perform(click())
    }
}