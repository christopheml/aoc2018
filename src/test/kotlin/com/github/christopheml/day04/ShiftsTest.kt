package com.github.christopheml.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShiftsTest {

    @Test
    internal fun most_asleep_minute_for_guard_not_sleeping() {
        val shifts = Shifts(listOf(ShiftBuilder(15).build()))
        val mostAsleepMinuteForGuard = shifts.mostAsleepMinuteForGuard(15)
        assertThat(mostAsleepMinuteForGuard).isEqualTo(Pair(-1, -1))
    }

}