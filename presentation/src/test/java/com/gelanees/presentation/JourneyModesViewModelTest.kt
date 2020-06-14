package com.gelanees.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.gelanees.design.R
import com.gelanees.domain.model.GetJourneyModesEntity
import com.gelanees.domain.usecase.GetJourneyModes
import com.gelanees.factory.ModeFactory
import com.gelanees.presentation.model.map
import com.gelanees.presentation.states.GetJourneyModesState
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.mockk
import io.uniflow.android.test.MockedViewObserver
import io.uniflow.android.test.mockObservers
import io.uniflow.core.flow.data.UIState
import io.uniflow.core.logger.DebugMessageLogger
import io.uniflow.core.logger.UniFlowLogger
import io.uniflow.test.rule.TestDispatchersRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest

class JourneyModesViewModelTest : KoinTest {
    @get:Rule
    var coroutinesMainDispatcherRule = TestDispatchersRule()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    init {
        UniFlowLogger.init(DebugMessageLogger())
    }

    private val getJourneyModes = mockk<GetJourneyModes>()
    private val modes = ModeFactory.makeModeList()
    private lateinit var viewModel : JourneyModesViewModel
    private lateinit var view: MockedViewObserver

    @Before
    fun setup(){
        viewModel = JourneyModesViewModel(getJourneyModes)
        view = viewModel.mockObservers()
    }

    @Test
    fun `GIVEN get journey modes successful WHEN getJourneyModes() THEN show LoadedState`() {
        coEvery { getJourneyModes() } returns GetJourneyModesEntity.Success(modes)

        viewModel.loadJourneyModes()

        coVerifySequence {
            view.hasState(UIState.Empty)
            view.hasState(GetJourneyModesState.LoadingState)
            view.hasState(GetJourneyModesState.LoadedState(modes.map { it.map() }))
        }
    }

    @Test
    fun `GIVEN get journey modes server error WHEN getJourneyModes() THEN show ErrorState`() {
        coEvery { getJourneyModes() } returns GetJourneyModesEntity.Error(404, "Not Found")

        viewModel.loadJourneyModes()

        coVerifySequence {
            view.hasState(UIState.Empty)
            view.hasState(GetJourneyModesState.LoadingState)
            view.hasState(GetJourneyModesState.ErrorState(R.string.error_unknown))
        }
    }

    @Test
    fun `GIVEN get journey modes internet error WHEN getJourneyModes() THEN show ErrorState`() {
        coEvery { getJourneyModes() } returns GetJourneyModesEntity.IOException

        viewModel.loadJourneyModes()

        coVerifySequence {
            view.hasState(UIState.Empty)
            view.hasState(GetJourneyModesState.LoadingState)
            view.hasState(GetJourneyModesState.ErrorState(R.string.error_no_internet))
        }
    }
}