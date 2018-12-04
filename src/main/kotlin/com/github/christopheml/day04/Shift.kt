package com.github.christopheml.day04

class Shift(val id: Int, private val shift: Array<Boolean>) {

    fun minutesAsleep(): Int {
        return shift.count { !it }
    }

    fun detailedMinutesAsleep(): Collection<Int> {
        return shift.indices.filter { !shift[it] }
    }

}
