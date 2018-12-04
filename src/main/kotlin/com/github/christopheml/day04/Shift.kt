package com.github.christopheml.day04

class Shift(private val shift: Array<Boolean>) {

    fun minutesAsleep(): Int {
        return shift.count { !it }
    }

}
