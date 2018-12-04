package com.github.christopheml.day04

class Shift(val id: Int, private val shift: Collection<Int>) {

    fun timeAsleep(): Int {
        return shift.count()
    }

    fun minutesAsleep(): Collection<Int> {
        return shift
    }

}
