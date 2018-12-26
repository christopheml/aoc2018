package com.github.christopheml.day25

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoordinateTest {

    @Test
    internal fun simple_distance_test() {
        val origin = parse("0,0,0,0")
        val other = parse("0,-12,0,0")
        assertThat(other.distanceFrom(origin)).isEqualTo(12)
    }

}
