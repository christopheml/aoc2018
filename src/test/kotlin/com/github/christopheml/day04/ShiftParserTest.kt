package com.github.christopheml.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShiftParserTest {

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

        val shifts = ShiftParser(log).parse()
        assertThat(shifts).hasSize(5)

        assertThat(shifts[0].timeAsleep()).isEqualTo(45)
        assertThat(shifts[1].timeAsleep()).isEqualTo(10)
        assertThat(shifts[1].minutesAsleep()).containsExactly(40, 41, 42, 43, 44, 45, 46, 47, 48, 49)
    }

}
