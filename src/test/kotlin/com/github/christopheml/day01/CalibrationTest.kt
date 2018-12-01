package com.github.christopheml.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalibrationTest {

    @Test
    internal fun one_change_up() {
        val calibration = Calibration(listOf("+3"))
        assertThat(calibration.frequency()).isEqualTo(3)
    }

    @Test
    internal fun one_change_down() {
        val calibration = Calibration(listOf("-9"))
        assertThat(calibration.frequency()).isEqualTo(-9)
    }

    @Test
    internal fun multiple_changes() {
        val calibration = Calibration(listOf("-3", "+6", "-7", "+9"))
        assertThat(calibration.frequency()).isEqualTo(5)
    }

    @Test
    internal fun first_frequency_reached_twice_acceptance1() {
        val calibration = Calibration(listOf("+3", "+3", "+4", "-2", "-4"))
        assertThat(calibration.firstReachedTwiceFrequency()).isEqualTo(10)
    }

    @Test
    internal fun first_frequency_reached_twice_acceptance2() {
        val calibration = Calibration(listOf("-6", "+3", "+8", "+5", "-6"))
        assertThat(calibration.firstReachedTwiceFrequency()).isEqualTo(5)
    }

    @Test
    internal fun first_frequency_reached_twice_acceptance3() {
        val calibration = Calibration(listOf("+7", "+7", "-2", "-7", "-4"))
        assertThat(calibration.firstReachedTwiceFrequency()).isEqualTo(14)
    }

}
