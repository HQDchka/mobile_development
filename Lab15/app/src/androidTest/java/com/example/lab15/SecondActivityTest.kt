package com.example.lab15

import android.graphics.Color
import android.os.SystemClock
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SecondActivityTest {

    @get:Rule
    val activity = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun testButtonChangesToRedAndRestoresOriginalColor() {
        var originalColor: Int? = null
        activity.scenario.onActivity { activity ->
            val btn = activity.findViewById<Button>(R.id.button_change_color)
            originalColor = btn.backgroundTintList?.defaultColor
        }

        onView(withId(R.id.button_change_color)).perform(click())
        onView(withId(R.id.button_change_color)).check { view, noViewFoundException ->
            val button = view as Button
            assertEquals(Color.RED, button.backgroundTintList?.defaultColor)
        }
        SystemClock.sleep(3000)
        onView(withId(R.id.button_change_color)).check { view, noViewFoundException ->
            val button = view as Button
            assertEquals(originalColor, button.backgroundTintList?.defaultColor)
        }
    }
}