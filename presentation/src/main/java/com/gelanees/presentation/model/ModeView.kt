package com.gelanees.presentation.model

import androidx.annotation.DrawableRes
import com.gelanees.domain.model.Mode

data class ModeView(
    val description: String,
    @DrawableRes val icon : Int
)

fun Mode.map(): ModeView {
    val mode = Modes.values().first { it.id == this.modeName }
    return ModeView(
        description = mode.desc,
        icon =  mode.icon
    )
}
