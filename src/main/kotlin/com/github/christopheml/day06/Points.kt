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

        val touchingEdges = areas
            .filter { e -> isOnEdge(e.key) }
            .values.distinct()

        val areaSizes = areas.values
            .groupingBy { it }
            .eachCount()
            .filterKeys { !touchingEdges.contains(it) }

        return areaSizes.values.max()!!
    }

    private fun mapPointsToCoordinates(): Map<Point, Point?> {
        return areaPoints()
            .associateBy({ it }, { closestPointFrom(it) })
            .filterValues { it != null }
    }

    fun closestRegion(): Collection<Point> {
        return areaPoints()
            .associateBy({ it }, { distanceFromAllCoordinates(it) })
            .filterValues { it < 10000 }
            .keys
    }

    private fun distanceFromAllCoordinates(point: Point) =
        coordinates.map { point.distanceFrom(it) }.sum()

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
    val input = PuzzleInput(6).asList()
        .map { s -> s.split(", ") }
        .map { (x, y) -> Point(x.toInt(), y.toInt()) }
        .toList()

    val points = Points(input)

    println("Solution to the first part is ${points.biggestFiniteArea()}")
    println("Solution to the second part is ${points.closestRegion().size}")
}
