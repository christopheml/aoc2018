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

}