package com.carolmusyoka.workoutapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carolmusyoka.workoutapp.R
import com.carolmusyoka.workoutapp.databinding.ItemIndividualExerciseBinding
import com.carolmusyoka.workoutapp.data.entity.Exercise

class ExerciseAdapter(
    private val exercises: MutableList<Exercise>
) : RecyclerView.Adapter<ExerciseAdapter.ExerciseVH>() {

    private var listener: ((Exercise) -> Unit)? = null
    private lateinit var binding: ItemIndividualExerciseBinding

    fun showData(exercises: List<Exercise>){
        this.exercises.clear()
        this.exercises.addAll(exercises)
        notifyDataSetChanged()
    }

    fun setOnExerciseListener(listener: ((Exercise) -> Unit)) {
        this.listener = listener
    }

    inner class ExerciseVH(itemView: ItemIndividualExerciseBinding) : RecyclerView.ViewHolder(itemView.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseVH {
        binding = ItemIndividualExerciseBinding.inflate(LayoutInflater.from(parent.context), parent,false )
        return ExerciseVH(binding)
    }


    override fun getItemCount(): Int {
        return exercises.size
    }

    override fun onBindViewHolder(holder: ExerciseVH, position: Int) {
        val item = exercises[position]

        holder.itemView.apply {
            binding.apply {
                  exerciseName.text = item.exerciseName
                  difficultyLevel.text = item.difficultyLevel
                ("primary: " + item.primaryMuscles).also { primaryMuscles.text = it }
                ("secondary: " + item.secondaryMuscles).also { secondaryMuscles.text = it }
                  requiredEquipment.text = item.requiredEquipment

                Glide.with(mainExerciseImage.context)
                    .load(item.image)
                    .centerInside()
                    .placeholder(R.drawable.image_three)
                    .into(mainExerciseImage)
            }
            holder.itemView.setOnClickListener {
                listener?.invoke(exercises[position])
            }
        }

    }

}