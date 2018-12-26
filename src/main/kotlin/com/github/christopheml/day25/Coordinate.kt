package com.github.christopheml.day25

class Coordinate(private val x: Int, private val y: Int, private val z: Int, private val t: Int) {

    var constellation: Int = -1

    fun distanceFrom(other: Coordinate): Int {
        return Math.abs(x - other.x) + Math.abs(y - other.y) + Math.abs(z - other.z) + Math.abs(t - other.t)
    }

}

fun parse(text: String): Coordinate {
    val (x, y, z, t) = text.split(',').map { it.toInt() }
    return Coordinate(x, y, z, t)
}
