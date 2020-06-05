package com.gelanees.presentation.states

import androidx.annotation.StringRes
import com.gelanees.presentation.model.ModeView
import io.uniflow.core.flow.data.UIState

sealed class GetJourneyModesState : UIState() {
    object LoadingState : GetJourneyModesState()
    data class LoadedState(val modes: List<ModeView>) : GetJourneyModesState()
    data class ErrorState(@StringRes val errorMessage: Int) : GetJourneyModesState()
}