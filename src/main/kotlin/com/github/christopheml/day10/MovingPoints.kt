package com.github.christopheml.day10

import com.github.christopheml.common.Point
import com.github.christopheml.common.PuzzleInput

class MovingPoints(private val movingPoints: Collection<MovingPoint>) {

    private fun pointsAfter(seconds: Int): Collection<Point> {
        return movingPoints.map { it.positionAfter(seconds) }
    }

    fun timeForMinimumHeight(): Int {
        var previousHeight = Int.MAX_VALUE
        var secondsElapsed = 0
        while (true) {
            // Loop is guaranteed to stop because a solution exists
            val height = getHeight(pointsAfter(secondsElapsed))

            if (height > previousHeight) {
                // Height is increasing again so we must have hit the minimum in the previous second
                return secondsElapsed - 1
            }

            previousHeight = height
            secondsElapsed++
        }
    }

    private fun getHeight(points: Iterable<Point>): Int {
        val heightCoordinates = points.map { it.y }.distinct().toList()
        return heightCoordinates.max()!! - heightCoordinates.min()!! + 1
    }

    fun representationAfter(seconds: Int): String {
        val finalPosition = pointsAfter(seconds)
        val characters = ArrayList<Char>()

        for (y in finalPosition.map { it.y }.min()!! .. finalPosition.map { it.y }.max()!!) {
            for (x in finalPosition.map { it.x }.min()!! .. finalPosition.map { it.x }.max()!!) {
                if (finalPosition.count { it.x == x && it.y == y } > 0) {
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

    val messageTime = movingPoints.timeForMinimumHeight()
    val message = movingPoints.representationAfter(messageTime)

    println(message)

    println("Message appeared after $messageTime seconds")
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
