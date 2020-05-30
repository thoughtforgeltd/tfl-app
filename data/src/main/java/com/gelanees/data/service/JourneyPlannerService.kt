package com.gelanees.data.service

import com.gelanees.data.model.ModeJson
import retrofit2.Response

interface JourneyPlannerService {
    fun getAvailablePlannerModes() : Response<List<ModeJson>>
}