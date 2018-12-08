package com.github.christopheml.day03

import com.github.christopheml.common.Point
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClaimTest {

    @Test
    internal fun points_generation() {
        val claim = Claim("#1", Point(1, 1), 2, 2)
        assertThat(claim.points().toList()).containsExactlyInAnyOrder(
            Point(1, 1),
            Point(1, 2),
            Point(2, 1),
            Point(2 ,2)
        )
    }

}
