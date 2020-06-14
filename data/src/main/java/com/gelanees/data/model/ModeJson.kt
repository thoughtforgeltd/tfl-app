package com.gelanees.data.model

import com.gelanees.domain.model.Mode
import com.google.gson.annotations.SerializedName

data class ModeJson(
    @SerializedName("isTflService")
    val isTflService : Boolean,
    @SerializedName("isFarePaying")
    val isFarePaying : Boolean,
    @SerializedName("isScheduledService")
    val isScheduledService : Boolean,
    @SerializedName("modeName")
    val modeName : String
)

fun ModeJson.map() : Mode{
    return Mode(
        modeName = this.modeName
    )
}