package com.example.android.testing.espresso.BasicSample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun ensureTextChangesWork() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("HELLO"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged)).check(matches(withText("HELLO")))
    }

    @Test
    fun ensureActivityChangeTextButtonWorks() {
        // Type text and then press the button to start the new activity.
        onView(withId(R.id.editTextUserInput))
            .perform(typeText("NEW ACTIVITY"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.show_text_view)).check(matches(withText("NEW ACTIVITY")))
    }
}
