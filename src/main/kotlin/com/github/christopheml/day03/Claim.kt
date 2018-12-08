package com.github.christopheml.day03

import com.github.christopheml.common.Point

internal class Claim(internal val id: String, private val origin: Point, private val width: Int, private val height: Int) {

    fun points(): Sequence<Point> {
        return iterator {
            for (x in 0 until width) {
                for (y in 0 until height) {
                    yield(Point(x + origin.x, y + origin.y))
                }
            }
        }.asSequence()
    }

}
