package com.gelanees.data.repository

import com.gelanees.data.factory.ModeJsonFactory
import com.gelanees.data.model.ModeJson
import com.gelanees.data.model.map
import com.gelanees.data.service.JourneyPlannerService
import com.gelanees.domain.model.GetJourneyModesEntity
import com.gelanees.domain.repository.IJourneyRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class JourneyRepositoryTest {
    private val journeyPlannerService = mockk<JourneyPlannerService>()
    private lateinit var journeyRepository: IJourneyRepository
    private val getAvailablePlannerModesResponse = mockk<Response<List<ModeJson>>>()
    private val listOfModeJson = ModeJsonFactory.makeModeJsonList()

    @Before
    fun setUp() {
        journeyRepository = JourneyRepositoryImpl(journeyPlannerService)
    }

    @Test
    fun `test success for getAvailablePlannerModes() returns data`() = runBlockingTest {
        every { getAvailablePlannerModesResponse.isSuccessful } returns true
        every { getAvailablePlannerModesResponse.code() } returns 200
        every { getAvailablePlannerModesResponse.body() } returns listOfModeJson
        coEvery { journeyPlannerService.getAvailablePlannerModes() } returns getAvailablePlannerModesResponse

        val expected =
            GetJourneyModesEntity.Success(modes = listOfModeJson.map { it.map() })
        val actual = journeyRepository.getAvailablePlannerModes()
        Assert.assertEquals(expected, actual)
    }

}