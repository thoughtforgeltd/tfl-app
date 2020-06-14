package com.gelanees.demo.modes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.gelanees.demo.R
import com.gelanees.demo.adapter.JourneyModesAdapter
import com.gelanees.presentation.JourneyModesViewModel
import com.gelanees.presentation.states.GetJourneyModesState
import io.uniflow.androidx.flow.onStates
import kotlinx.android.synthetic.main.fragment_hourney_modes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class JourneyModesFragment : Fragment(){
    private val vm: JourneyModesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hourney_modes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStates(vm){
            when (it) {
                is GetJourneyModesState.LoadingState -> showLoadingState()
                is GetJourneyModesState.LoadedState -> showLoadedState(it)
                is GetJourneyModesState.ErrorState -> showErrorState(it)
            }
        }
        vm.loadJourneyModes()
    }

    private fun showErrorState(errorState: GetJourneyModesState.ErrorState) {
        loading.hide()
        Toast.makeText(this.context, getString(errorState.errorMessage), Toast.LENGTH_SHORT).show()
    }

    private fun showLoadedState(loadedState: GetJourneyModesState.LoadedState) {
        loading.hide()
        list_modes.isVisible = true
        list_modes.adapter = JourneyModesAdapter(loadedState.modes)
    }

    private fun showLoadingState() {
        loading.show()
    }
}