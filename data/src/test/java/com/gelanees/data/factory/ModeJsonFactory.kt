package com.gelanees.data.factory

import com.gelanees.data.model.ModeJson

object ModeJsonFactory {
    fun makeModeJsonList(size: Int = 3) : List<ModeJson>{
        val result = mutableListOf<ModeJson>()
        repeat(size){
            result.add(
                makeModeJson(it)
            )
        }
        return result
    }

    private fun makeModeJson(it: Int): ModeJson {
        return ModeJson(
            isTflService = it % 2 == 0,
            isFarePaying = it % 2 != 0,
            isScheduledService = it % 2 == 0,
            modeName = "modeName$it"
        )
    }
}