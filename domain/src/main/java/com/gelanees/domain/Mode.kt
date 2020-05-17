package com.gelanees.domain

data class Mode(
    val isTflService: Boolean,
    val isFarePaying: Boolean,
    val isScheduledService: Boolean,
    val modeName: String
)