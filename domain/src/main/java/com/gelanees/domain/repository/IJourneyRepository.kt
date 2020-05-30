package com.gelanees.domain.repository

import com.gelanees.domain.model.GetAvailablePlannerModesResult

interface IJourneyRepository {
    suspend fun getAvailablePlannerModes() : GetAvailablePlannerModesResult
}