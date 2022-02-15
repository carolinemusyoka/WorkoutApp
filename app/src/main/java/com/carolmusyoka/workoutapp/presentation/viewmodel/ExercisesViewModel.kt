package com.carolmusyoka.workoutapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.carolmusyoka.workoutapp.data.db.ExerciseDatabase
import com.carolmusyoka.workoutapp.data.entity.Exercise
import com.carolmusyoka.workoutapp.domain.ExerciseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class ExercisesViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository: ExerciseRepository
    val difficulty = MutableStateFlow("all")

    init {
       val exerciseDao = ExerciseDatabase
           .getDatabase(application, viewModelScope, application.resources)
           .exerciseDao()
        repository = ExerciseRepository(exerciseDao)
    }

     val selectedExercise = MutableLiveData<Exercise>()

    fun setSelectedExercise(exercise: Exercise){
        selectedExercise.value = exercise
    }

    fun getAllExercises(): LiveData<List<Exercise>>{
        return repository.getAllExercises()
    }

    val exercises = difficulty.flatMapLatest {
        repository.getAllOrSearch(it)
    }.asLiveData()

    fun getExercisesByDifficulty(difficulty: String): LiveData<List<Exercise>>{
        return repository.getExercisesByDifficulty(difficulty)
    }


}