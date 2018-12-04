package com.github.christopheml.day04

internal class Shifts(private val shifts: Collection<Shift>) {

    fun mostAsleepGuard(): Int {
        return shifts
            .groupBy({ it.id }, { it.minutesAsleep() })
            .mapValues { e -> e.value.sum() }
            .maxBy { e -> e.value }!!.key
    }

    fun mostAsleepMinuteForGuard(id: Int): Int {
        return shifts
            .filter { it.id == id }
            .map { it -> it.detailedMinutesAsleep() }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .maxBy { e -> e.value }!!.key
    }

}
