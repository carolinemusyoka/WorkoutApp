package com.carolmusyoka.workoutapp.domain

import androidx.lifecycle.LiveData
import com.carolmusyoka.workoutapp.data.db.ExerciseDao
import com.carolmusyoka.workoutapp.data.entity.Exercise
import kotlinx.coroutines.flow.Flow


class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    fun getAllExercises(): LiveData<List<Exercise>> {
        return exerciseDao.getExercises()
    }
    fun getExercisesByDifficulty(difficulty: String): LiveData<List<Exercise>>{
        return exerciseDao.getDifficulty(difficulty)
    }

    fun getAllOrSearch(difficulty: String): Flow<List<Exercise>> {
        return if (difficulty == "all") {
            exerciseDao.getAllExercises()
        } else {
            exerciseDao.getByDifficulty(difficulty)
        }
    }
}