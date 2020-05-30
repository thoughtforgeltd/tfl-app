package com.gelanees.domain.model

data class Mode(
    val isTflService: Boolean,
    val isFarePaying: Boolean,
    val isScheduledService: Boolean,
    val modeName: String
)