package com.gelanees.presentation.model

import com.gelanees.domain.model.GetJourneyModesEntity
import com.gelanees.presentation.states.GetJourneyModesState
import com.gelanees.design.R.string as RS

sealed class GetJourneyModesResult {
    data class Success(val modes: List<ModeView>) : GetJourneyModesResult()
    object Error : GetJourneyModesResult()
    object NoNetwork : GetJourneyModesResult()
}

fun GetJourneyModesEntity.map(): GetJourneyModesResult =
    when (this) {
        is GetJourneyModesEntity.Success -> GetJourneyModesResult.Success(this.modes.map { it.map() })
        is GetJourneyModesEntity.Error -> GetJourneyModesResult.Error
        GetJourneyModesEntity.IOException -> GetJourneyModesResult.NoNetwork
    }

fun GetJourneyModesResult.toState(): GetJourneyModesState =
    when (this) {
        is GetJourneyModesResult.Success -> GetJourneyModesState.LoadedState(this.modes)
        is GetJourneyModesResult.Error -> GetJourneyModesState.ErrorState(RS.error_unknown)
        GetJourneyModesResult.NoNetwork -> GetJourneyModesState.ErrorState(RS.error_no_internet)
    }