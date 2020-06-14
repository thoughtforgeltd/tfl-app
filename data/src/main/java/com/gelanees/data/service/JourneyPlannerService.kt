package com.gelanees.data.service

import com.gelanees.data.model.ModeJson
import retrofit2.Response
import retrofit2.http.GET

interface JourneyPlannerService {
    @GET("/Journey/Meta/Modes?app_id=ec0be45c&app_key=362b04816e25244fba6a30f4856301a8")
    suspend fun getAvailablePlannerModes() : Response<List<ModeJson>>
}