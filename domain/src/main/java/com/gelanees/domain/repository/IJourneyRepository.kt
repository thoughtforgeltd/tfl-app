package com.gelanees.domain.repository

import com.gelanees.domain.model.GetJourneyModesEntity

interface IJourneyRepository {
    suspend fun getAvailablePlannerModes() : GetJourneyModesEntity
}