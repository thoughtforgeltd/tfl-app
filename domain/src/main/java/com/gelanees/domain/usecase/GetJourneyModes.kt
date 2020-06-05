package com.gelanees.domain.usecase

import com.gelanees.domain.model.GetJourneyModesEntity
import com.gelanees.domain.repository.IJourneyRepository

class GetJourneyModes(private val journeyRepository: IJourneyRepository) {
    suspend operator fun invoke() : GetJourneyModesEntity{
        return journeyRepository.getAvailablePlannerModes()
    }
}