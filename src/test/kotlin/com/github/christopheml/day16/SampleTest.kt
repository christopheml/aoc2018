package com.github.christopheml.day16

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SampleTest {

    @Test
    internal fun acceptance_test() {
        val sample = Sample(listOf(3, 2, 1, 1), listOf(9, 2, 1, 2), listOf(3, 2, 2, 1))
        assertThat(sample.matches(allInstructions())).isEqualTo(3)
    }

}
