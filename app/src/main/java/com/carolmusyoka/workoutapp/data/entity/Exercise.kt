package com.carolmusyoka.workoutapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "exercise")
data class Exercise(
 @PrimaryKey(autoGenerate = true) val id: Int,
 @SerializedName("name") val exerciseName: String,
 @SerializedName("image") val image: String,
 @SerializedName("secondary_image") val secondaryImage: String,
 @SerializedName("description") val description: String,
 @SerializedName("difficulty") val difficultyLevel: String,
 @SerializedName("equipment") val requiredEquipment: String,
 @SerializedName("primary") val primaryMuscles: String,
 @SerializedName("secondary") val secondaryMuscles: String
)