package com.carolmusyoka.workoutapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.carolmusyoka.workoutapp.presentation.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun return_true_recyclerview_is_showing() {
        Espresso.onView(withId(R.id.rv_exercises))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun return_true_appBar_is_showing() {
        Espresso.onView(withId(R.id.appBarLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun return_true_chip_is_showing() {
        Espresso.onView(withId(R.id.layout_chip))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}