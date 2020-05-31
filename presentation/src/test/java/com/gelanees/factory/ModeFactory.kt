package com.gelanees.factory

import com.gelanees.domain.model.Mode

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
            modeName = "modeName$it"
        )
    }
}