package com.carolmusyoka.workoutapp

import android.content.Context
import androidx.room.Room
import androidx.room.withTransaction
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.carolmusyoka.workoutapp.data.db.ExerciseDatabase
import com.carolmusyoka.workoutapp.data.entity.Exercise
import com.carolmusyoka.workoutapp.presentation.ui.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.InputStream


@RunWith(AndroidJUnit4::class)
class RoomDBTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    private lateinit var context: Context
    private lateinit var db: ExerciseDatabase
    private lateinit var exercises:List<Exercise>


    @Before
    fun setUp() {

        context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, ExerciseDatabase::class.java).build()

        val jsonStream: InputStream = context.resources.openRawResource(R.raw.exercises)
        val jsonBytes: ByteArray = jsonStream.readBytes()

        val typeToken = object : TypeToken<List<Exercise>>() {}.type
        exercises = Gson().fromJson(String(jsonBytes), typeToken)

        runBlocking {
            db.withTransaction {
                db.exerciseDao().insertAllExercises(exercises)
            }
        }
    }

    @Test
    fun get_exercise_size_returns_4() {
        runBlocking {
            assertThat(db.exerciseDao().getExercisesList().size, CoreMatchers.equalTo(4))
        }
    }

    @After
    fun clear() {
        db.clearAllTables()
        db.close()
    }

}