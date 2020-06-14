package com.gelanees.presentation.model

import androidx.annotation.DrawableRes
import com.gelanees.domain.model.Mode

data class ModeView(
    val description: String,
    @DrawableRes val icon : Int
)

fun Mode.map(): ModeView {
    val mode = Modes.values().firstOrNull() { it.id == this.modeName }
    return ModeView(
        description = mode?.desc ?: Modes.UNKNOWN.desc,
        icon =  mode?.icon ?: Modes.UNKNOWN.icon
    )
}
