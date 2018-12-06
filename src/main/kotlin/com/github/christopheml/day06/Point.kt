package com.github.christopheml.day06

data class Point(val x: Int, val y: Int) {

    fun isOnSameLine(other: Point): Boolean {
        return x == other.x || y == other.y
    }

    fun findClosest(others: Collection<Point>): Collection<Point> {
        return others
            .groupBy { p -> distanceFrom(p) }
            .minBy { e -> e.key }!!.value
    }

    private fun distanceFrom(other: Point): Int {
        return Math.abs(x - other.x) + Math.abs(y - other.y)
    }

}
