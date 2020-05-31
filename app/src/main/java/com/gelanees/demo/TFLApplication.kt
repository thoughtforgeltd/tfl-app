package com.gelanees.demo

import android.app.Application
import com.gelanees.presentation.di.presentation_journey_planner_module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TFLApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@TFLApplication)
            modules(presentation_journey_planner_module)
        }
    }
}