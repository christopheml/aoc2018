package com.github.christopheml.day10

import com.github.christopheml.common.PuzzleInput

class MovingPoints(private val points: Collection<MovingPoint>) {

    fun move() {
        points.forEach { it.move() }
    }

    fun detectVerticalLines(threshold: Int): Int {
        return points
            .map { it.x }
            .groupingBy { it }
            .eachCount()
            .filterValues { it >= threshold }
            .count()
    }

    fun height(): Int {
        return points.map { it.y }.max()!! - points.map { it.y }.min()!! + 1
    }

    fun render(): String {
        val minX = points.map { it.x }.min()!!
        val minY = points.map { it.y }.min()!!
        val maxX = points.map { it.x }.max()!!
        val maxY = points.map { it.y }.max()!!

        val characters = ArrayList<Char>()

        for (y in minY..maxY) {
            for (x in minX..maxX) {
                if (points.count { it.x == x && it.y == y } > 0) {
                    characters.add('#')
                } else {
                    characters.add(' ')
                }
            }
            characters.add('\n')
        }
        return characters.joinToString("")
    }

}

fun main(args: Array<String>) {
    val movingPoints = build(PuzzleInput(10).asList())

    var height = 0
    var iteration = 0

    while (height != 10) {
        movingPoints.move()
        iteration++
        height = movingPoints.height()
    }

    print(movingPoints.render())
    println("Verticality is " + movingPoints.detectVerticalLines(10))
    println("Message appeared after iteration $iteration")
}

fun build(input: List<String>): MovingPoints {
    val regex = Regex("""position=<\s*(-?\d+),\s*(-?\d+)> velocity=<\s*(-?\d+),\s*(-?\d+)>""")
    val points = input.map {
        val result = regex.matchEntire(it)!!
        val (x, y, vX, vY) = result.destructured
        MovingPoint(x.toInt(), y.toInt(), vX.toInt(), vY.toInt())
    }
    return MovingPoints(points)
}
