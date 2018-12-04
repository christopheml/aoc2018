package com.github.christopheml.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ShiftTest {

    @Test
    internal fun fully_awake_shift() {
        val shift = ShiftBuilder(9).build()
        assertThat(shift.timeAsleep()).isEqualTo(0)
    }

    @Test
    internal fun fully_asleep_shift() {
        val shift = ShiftBuilder(4)
            .sleeps(0)
            .build()
        assertThat(shift.timeAsleep()).isEqualTo(60)
    }

    @Test
    internal fun simple_shift() {
        val shift = ShiftBuilder(11)
            .sleeps(40)
            .wakesUp(50)
            .build()
        assertThat(shift.timeAsleep()).isEqualTo(10)
    }

    @Test
    internal fun complex_shift() {
        val shift = ShiftBuilder(90)
            .sleeps(5)
            .wakesUp(25)
            .sleeps(30)
            .wakesUp(55)
            .build()
        assertThat(shift.timeAsleep()).isEqualTo(45)
    }

}
