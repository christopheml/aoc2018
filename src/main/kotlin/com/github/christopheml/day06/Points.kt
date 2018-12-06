package com.github.christopheml.day06

import com.github.christopheml.common.PuzzleInput

class Points(private val coordinates: Collection<Point>) {

    val enclosingArea = enclosingArea()

    private fun enclosingArea(): Pair<Point, Point> {
        val minX = coordinates.map { p -> p.x }.min()!!
        val minY = coordinates.map { p -> p.y }.min()!!
        val maxX = coordinates.map { p -> p.x }.max()!!
        val maxY = coordinates.map { p -> p.y }.max()!!

        return Pair(Point(minX, minY), Point(maxX, maxY))
    }

    fun biggestFiniteArea(): Int {
        val areas = mapPointsToCoordinates()

        val pointsWithAreaTouchingEdge = areas
            .filter { e -> isOnEdge(e.key) }
            .values.distinct()

        val candidates = coordinates
            .filter { p -> !isOnEdge(p) }
            .filter { p -> !pointsWithAreaTouchingEdge.contains(p) }

        val areaSizes = areas.values
            .groupingBy { it }
            .eachCount()
            .filter { e -> candidates.contains(e.key) }

        return areaSizes.values.max()!!
    }

    private fun mapPointsToCoordinates(): Map<Point, Point?> {
        return areaPoints()
            .associateBy({ it }, { closestPointFrom(it) })
            .filterValues { it != null }
    }

    private fun areaPoints(): Sequence<Point> {
        return iterator {
            for (x in enclosingArea.first.x until enclosingArea.second.x + 1) {
                for (y in enclosingArea.first.y until enclosingArea.second.y + 1) {
                    yield(Point(x, y))
                }
            }
        }.asSequence()
    }

    private fun closestPointFrom(point: Point): Point? {
        val closestPoints = point.findClosest(coordinates)
        if (closestPoints.size == 1) {
            return closestPoints.first()
        }
        return null
    }

    private fun isOnEdge(point: Point): Boolean {
        return point.isOnSameLine(enclosingArea.first) || point.isOnSameLine(enclosingArea.second)
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput("day06.txt").asList()
        .map { s -> s.split(", ") }
        .map { (x, y) -> Point(x.toInt(), y.toInt()) }
        .toList()

    val result = Points(input).biggestFiniteArea()
    println("Solution to the first part is $result")
}
