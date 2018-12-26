package com.github.christopheml.day25

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConstellationMapperTest {

    @Test
    internal fun acceptance_test_1() {
        val textCoordinates = listOf(
            "0,0,0,0",
            "3,0,0,0",
            "0,3,0,0",
            "0,0,3,0",
            "0,0,0,3",
            "0,0,0,6",
            "9,0,0,0",
            "12,0,0,0"
        )

        val mapper = ConstellationMapper(textCoordinates.map { parse(it) })
        assertThat(mapper.map()).isEqualTo(2)
    }

    @Test
    internal fun acceptance_test_2() {
        val textCoordinates = listOf(
            "-1,2,2,0",
            "0,0,2,-2",
            "0,0,0,-2",
            "-1,2,0,0",
            "-2,-2,-2,2",
            "3,0,2,-1",
            "-1,3,2,2",
            "-1,0,-1,0",
            "0,2,1,-2",
            "3,0,0,0"
        )

        val mapper = ConstellationMapper(textCoordinates.map { parse(it) })
        assertThat(mapper.map()).isEqualTo(4)
    }

}
