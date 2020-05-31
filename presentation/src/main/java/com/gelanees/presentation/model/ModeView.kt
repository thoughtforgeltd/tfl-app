package com.gelanees.presentation.model

import com.gelanees.domain.model.Mode

data class ModeView(
    val modeName: String
)

fun Mode.map(): ModeView {
    return ModeView(
        modeName = this.modeName
    )
}