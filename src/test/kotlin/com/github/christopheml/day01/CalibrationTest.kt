package com.github.christopheml.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalibrationTest {

    @Test
    internal fun one_change_up() {
        val calibration = Calibration("+3")
        assertThat(calibration.frequency()).isEqualTo(3)
    }

}
