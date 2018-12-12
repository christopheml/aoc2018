package com.github.christopheml.day10

import com.github.christopheml.common.Point

class MovingPoint(private val x: Int, private val y: Int, private val vX: Int, private val vY: Int) {

    fun positionAfter(seconds: Int): Point {
        return Point(x + (seconds * vX), y + (seconds * vY))
    }

}
