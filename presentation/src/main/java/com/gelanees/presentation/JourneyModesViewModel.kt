package com.gelanees.presentation

import com.gelanees.domain.usecase.GetJourneyModes
import com.gelanees.presentation.model.map
import com.gelanees.presentation.model.toState
import com.gelanees.presentation.states.GetJourneyModesState
import io.uniflow.androidx.flow.AndroidDataFlow

class JourneyModesViewModel(private val getJourneyModes: GetJourneyModes) : AndroidDataFlow() {
    fun loadJourneyModes() = action {
        setState(GetJourneyModesState.LoadingState)
        setState(getJourneyModes().map().toState())
    }
}