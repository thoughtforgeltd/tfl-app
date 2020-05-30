package com.gelanees.domain.model

sealed class GetAvailablePlannerModesResult {
    data class Success(val modes : List<Mode>) : GetAvailablePlannerModesResult()
    data class Error(val code : Int, val message : String) : GetAvailablePlannerModesResult()
    object IOException : GetAvailablePlannerModesResult()
}