package com.github.christopheml.day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ClaimTest {

    @Test
    internal fun points_generation() {
        val claim = Claim(Pair(1, 1), Pair(2, 2))
        assertThat(claim.points()).containsExactlyInAnyOrder(
            Pair(1, 1),
            Pair(1, 2),
            Pair(2, 1),
            Pair(2 ,2)
        )
    }

}
