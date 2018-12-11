package com.github.christopheml.day11

import com.github.christopheml.common.Point

class FuelCells(private val serialNumber: Int) {

    fun valueAt(x: Int, y: Int): Int {
        val rackId = x + 10
        val powerLevel = (rackId * y + serialNumber) * rackId
        val digit = (powerLevel / 100) % 10
        return digit - 5
    }

    fun locateHighestChargedCell(): Point {
        var highestValue = 0
        var location = Point(0 ,0)
        for (x in 1 .. 297) {
            for (y in 1 .. 297) {
                val currentValue =
                    valueAt(x, y) + valueAt(x + 1, y) + valueAt(x + 2, y) +
                            valueAt(x, y + 1) + valueAt(x + 1, y + 1) + valueAt(x + 2, y + 1) +
                            valueAt(x, y + 2) + valueAt(x + 1, y + 2) + valueAt(x + 2, y + 2)
                if (currentValue > highestValue) {
                    highestValue = currentValue
                    location = Point(x, y)
                }
            }
        }

        return location
    }

}

fun main(args: Array<String>) {
    val (x, y) = FuelCells(5177).locateHighestChargedCell()
    println("Solution to the first part is $x,$y")
}
