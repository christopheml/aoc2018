package com.github.christopheml.day03

import com.github.christopheml.common.Point
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FabricTest {

    private val claims = listOf(
        Claim("#1", Point(1, 3), 4, 4),
        Claim("#2", Point(3, 1), 4, 4),
        Claim("#3", Point(5, 5), 2, 2)
    )

    @Test
    internal fun acceptance_test_part1() {
        val fabric = Fabric()
        claims.forEach { fabric.claim(it) }

        assertThat(fabric.claimedTwice()).isEqualTo(4)
    }

    @Test
    internal fun acceptance_test_part2() {
        val fabric = Fabric()
        claims.forEach { fabric.claim(it) }

        assertThat(fabric.notOverlapping()).isEqualTo("#3")
    }

}
