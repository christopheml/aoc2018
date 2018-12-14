package com.github.christopheml.common

data class Point(val x: Int, val y: Int) : Comparable<Point> {

    override fun compareTo(other: Point): Int {
        val ownDistance = manhattanDistanceFrom(ORIGIN)
        val otherDistance = other.manhattanDistanceFrom(ORIGIN)
        return when {
            ownDistance < otherDistance -> -1
            ownDistance > otherDistance -> 1
            else -> 0
        }
    }

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

private val ORIGIN = Point(0, 0)
