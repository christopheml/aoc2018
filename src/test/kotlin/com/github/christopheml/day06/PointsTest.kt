package com.github.christopheml.day06

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PointsTest {

    private val points = Points(
        listOf(
            Point(1, 1),
            Point(1, 6),
            Point(8, 3),
            Point(3, 4),
            Point(5, 5),
            Point(8, 9)
        )
    )

    @Test
    internal fun enclosing_area() {
        val (topLeft, bottomRight) = points.enclosingArea
        assertThat(topLeft).isEqualTo(Point(1, 1))
        assertThat(bottomRight).isEqualTo(Point(8, 9))
    }

    @Test
    internal fun acceptance_test() {
        assertThat(points.biggestFiniteArea()).isEqualTo(17)
    }

}
