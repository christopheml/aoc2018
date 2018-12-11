package com.github.christopheml.day11

import com.github.christopheml.common.Point

class FuelCells(private val serialNumber: Int) {

    fun valueAt(x: Int, y: Int): Int {
        val rackId = x + 10
        val powerLevel = (rackId * y + serialNumber) * rackId
        val digit = (powerLevel / 100) % 10
        return digit - 5
    }

    fun locateHighestChargedCell(squareSize: Int): Point {
        var highestValue = 0
        var location = Point(0 ,0)
        for (x in 1 .. 300 - squareSize) {
            for (y in 1 .. 300 - squareSize) {
                val currentValue = getCellTotalPower(x, y, squareSize)
                if (currentValue > highestValue) {
                    highestValue = currentValue
                    location = Point(x, y)
                }
            }
        }

        return location
    }

    private fun getCellTotalPower(x: Int, y: Int, squareSize: Int): Int {
        var totalPower = 0
        for (xOffset in 0 until squareSize) {
            for (yOffset in 0 until squareSize) {
                totalPower += valueAt(x + xOffset, y + yOffset)
            }
        }
        return totalPower
    }

}

fun main(args: Array<String>) {
    val (x, y) = FuelCells(5177).locateHighestChargedCell(3)
    println("Solution to the first part is $x,$y")
}
