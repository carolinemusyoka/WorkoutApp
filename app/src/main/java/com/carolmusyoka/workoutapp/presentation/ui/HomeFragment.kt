package com.carolmusyoka.workoutapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.carolmusyoka.workoutapp.R
import com.carolmusyoka.workoutapp.databinding.FragmentHomeBinding
import com.carolmusyoka.workoutapp.presentation.adapter.ExerciseAdapter
import com.carolmusyoka.workoutapp.presentation.viewmodel.ExercisesViewModel
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private lateinit var exerciseViewModel: ExercisesViewModel
    private lateinit var exerciseAdapter: ExerciseAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity.let {
            exerciseViewModel = ViewModelProvider(it!!).get(ExercisesViewModel::class.java)
        }
        exerciseAdapter = ExerciseAdapter(mutableListOf())

        exerciseAdapter.setOnExerciseListener { exercise ->
            exerciseViewModel.setSelectedExercise(exercise)
            findNavController().navigate(R.id.exerciseDetailsFragment, arguments, NavOptions.Builder().setPopUpTo(R.id.exerciseDetailsFragment, true).build())
        }

        withTags()
        attachObservers()
    }

    private fun attachObservers() {
        exerciseViewModel.exercises.observe(viewLifecycleOwner) {
            binding.rvExercises.apply {
                adapter = exerciseAdapter
                layoutManager = LinearLayoutManager(activity)
            }
            exerciseAdapter.showData(it)
        }
    }


    private fun withTags() {
        binding.chipGroupFilter.children.forEach {
            val chip  = (it as Chip)
            chip.setOnCheckedChangeListener { _, b ->
                if (b) {
                        exerciseViewModel.difficulty.value = chip.tag as String
                }
            }
        }

    }

}