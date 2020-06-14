package com.gelanees.domain.model

sealed class GetJourneyModesEntity {
    data class Success(val modes : List<Mode>) : GetJourneyModesEntity()
    data class Error(val code : Int, val message : String) : GetJourneyModesEntity()
    object IOException : GetJourneyModesEntity()
}