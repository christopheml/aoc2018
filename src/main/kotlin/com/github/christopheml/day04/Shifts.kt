package com.github.christopheml.day04

internal class Shifts(private val shifts: Collection<Shift>) {

    fun mostAsleepGuard(): Int {
        return shifts
            .groupBy({ it.id }, { it.timeAsleep() })
            .mapValues { e -> e.value.sum() }
            .maxBy { e -> e.value }!!.key
    }

    fun mostAsleepMinuteForGuard(id: Int): Pair<Int, Int> {
        val shiftsWithSleep = shifts
            .filter { it.id == id && it.timeAsleep() > 0 }

        if (shiftsWithSleep.isEmpty()) {
            // Dirty hack to avoid guards without sleep
            return Pair(-1, -1)
        }

        return shiftsWithSleep
            .map { it -> it.minutesAsleep() }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .maxBy { e -> e.value }!!
            .toPair()
    }

    fun guards(): Collection<Int> {
        return shifts.map { it.id }.distinct()
    }

}
