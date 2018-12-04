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

    @Test
    internal fun acceptance_test() {
        val log = listOf(
            "[1518-11-01 00:00] Guard #10 begins shift",
            "[1518-11-01 00:05] falls asleep",
            "[1518-11-01 00:25] wakes up",
            "[1518-11-01 00:30] falls asleep",
            "[1518-11-01 00:55] wakes up",
            "[1518-11-01 23:58] Guard #99 begins shift",
            "[1518-11-02 00:40] falls asleep",
            "[1518-11-02 00:50] wakes up",
            "[1518-11-03 00:05] Guard #10 begins shift",
            "[1518-11-03 00:24] falls asleep",
            "[1518-11-03 00:29] wakes up",
            "[1518-11-04 00:02] Guard #99 begins shift",
            "[1518-11-04 00:36] falls asleep",
            "[1518-11-04 00:46] wakes up",
            "[1518-11-05 00:03] Guard #99 begins shift",
            "[1518-11-05 00:45] falls asleep",
            "[1518-11-05 00:55] wakes up"
        )

        val shifts = Shifts(ShiftParser(log).parse())
        assertThat(shifts.mostAsleepGuard()).isEqualTo(10)
        assertThat(shifts.mostAsleepMinuteForGuard(10)).isEqualTo(Pair(24, 2))
    }

}
