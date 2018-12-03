package com.github.christopheml.day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FabricTest {

    @Test
    internal fun acceptance_test() {
        val claims = listOf(
            Claim(Pair(1, 3), Pair(4, 4)),
            Claim(Pair(3, 1), Pair(4, 4)),
            Claim(Pair(5, 5), Pair(2, 2))
        )

        val fabric = Fabric()
        claims.forEach { fabric.claim(it) }

        assertThat(fabric.claimedTwice()).isEqualTo(4)
    }

}
