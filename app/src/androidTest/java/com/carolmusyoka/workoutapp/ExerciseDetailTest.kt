package com.carolmusyoka.workoutapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.carolmusyoka.workoutapp.presentation.ui.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExerciseDetailTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        runBlocking {
            delay(500)
            val recyclerView = onView(
                allOf(
                    withId(R.id.rv_exercises)
                )
            )
            recyclerView.perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        }

    }

    @Test
    fun return_true_imageView_is_showing() {
        onView(withId(R.id.exercise_image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun return_true_name_is_showing() {
       onView(withId(R.id.exercise_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}