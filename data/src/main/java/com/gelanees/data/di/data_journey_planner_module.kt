package com.gelanees.data.di

import com.gelanees.data.repository.JourneyRepositoryImpl
import com.gelanees.data.service.JourneyPlannerService
import com.gelanees.data.utils.createRetrofitService
import com.gelanees.domain.repository.IJourneyRepository
import com.gelanees.domain.usecase.GetJourneyModes
import org.koin.dsl.module

val data_journey_planner_module = data_common_module + module {
    single<JourneyPlannerService> { createRetrofitService(get()) }
    single<IJourneyRepository> { JourneyRepositoryImpl(get()) }
    factory { GetJourneyModes(get()) }
}