package com.github.christopheml.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShiftTest {

    @Test
    internal fun fully_awake_shift() {
        val shift = ShiftBuilder().build()
        assertThat(shift.minutesAsleep()).isEqualTo(0)
    }

    @Test
    internal fun fully_asleep_shift() {
        val shift = ShiftBuilder()
            .sleeps(0)
            .build()
        assertThat(shift.minutesAsleep()).isEqualTo(60)
    }

    @Test
    internal fun simple_shift() {
        val shift = ShiftBuilder()
            .sleeps(40)
            .wakesUp(50)
            .build()
        assertThat(shift.minutesAsleep()).isEqualTo(10)
    }

    @Test
    internal fun complex_shift() {
        val shift = ShiftBuilder()
            .sleeps(5)
            .wakesUp(25)
            .sleeps(30)
            .wakesUp(55)
            .build()
        assertThat(shift.minutesAsleep()).isEqualTo(45)
    }

}
