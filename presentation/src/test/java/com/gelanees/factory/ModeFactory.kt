package com.gelanees.factory

import com.gelanees.domain.model.Mode
import com.gelanees.presentation.model.Modes

object ModeFactory {
    fun makeModeList(size: Int = 3) : List<Mode>{
        val result = mutableListOf<Mode>()
        repeat(size){
            result.add(
                makeMode(it)
            )
        }
        return result
    }

    private fun makeMode(it: Int): Mode {
        return Mode(
            modeName = Modes.values()[it].id
        )
    }
}