package com.github.christopheml.common

data class Point(val x: Int, val y: Int) {

    fun isOnSameLine(other: Point): Boolean {
        return x == other.x || y == other.y
    }

    fun findClosest(others: Collection<Point>): Collection<Point> {
        return others
            .groupBy { p -> manhattanDistanceFrom(p) }
            .minBy { e -> e.key }!!.value
    }

    fun manhattanDistanceFrom(other: Point): Int {
        return Math.abs(x - other.x) + Math.abs(y - other.y)
    }

}
