package com.gelanees.presentation.di

import com.gelanees.data.di.data_journey_planner_module
import com.gelanees.presentation.JourneyModesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation_journey_planner_module = data_journey_planner_module + module {
    viewModel { JourneyModesViewModel(get()) }
}