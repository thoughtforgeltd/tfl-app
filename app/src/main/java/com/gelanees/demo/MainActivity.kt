package com.gelanees.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gelanees.presentation.JourneyModesViewModel
import com.gelanees.presentation.states.GetJourneyModesState
import io.uniflow.androidx.flow.onStates
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm: JourneyModesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        Toast.makeText(this, getString(errorState.errorMessage), Toast.LENGTH_SHORT).show()
    }

    private fun showLoadedState(loadedState: GetJourneyModesState.LoadedState) {
        loading.hide()
    }

    private fun showLoadingState() {
        loading.show()
    }
}
