package com.github.christopheml.day10

class MovingPoint(var x: Int, var y: Int, private val vX: Int, private val vY: Int) {

    fun move() {
        x += vX
        y += vY
    }

}
