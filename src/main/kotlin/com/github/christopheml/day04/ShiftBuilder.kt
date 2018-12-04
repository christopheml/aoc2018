package com.github.christopheml.day04

internal class ShiftBuilder(private val id: Int) {

    private var shift: Array<Boolean> = Array(60) { true }
    private var minute = 0
    private var asleep = false

    fun wakesUp(wakeUpMinute: Int): ShiftBuilder {
        sleepUntil(wakeUpMinute)
        minute = wakeUpMinute
        asleep = false
        return this
    }

    fun sleeps(fallingAsleepMinute: Int): ShiftBuilder {
        minute = fallingAsleepMinute
        asleep = true
        return this
    }

    private fun sleepUntil(end: Int) {
        for (i in minute until end) {
            shift[i] = false
        }
    }

    fun build(): Shift {
        if (asleep) {
            // Guard is still sleeping at the end of the shift
            sleepUntil(60)
        }
        return Shift(id, shift)
    }

}
