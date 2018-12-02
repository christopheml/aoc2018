package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DetectorTest {

    @Test
    internal fun acceptance_test() {
        val detector = Detector(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"))
        assertThat(detector.find()).isEqualTo("fgij")
    }

}
