package com.github.christopheml.day11

class FuelCells(private val serialNumber: Int) {

    fun valueAt(x: Int, y: Int): Int {
        val rackId = x + 10
        val powerLevel = (rackId * y + serialNumber) * rackId
        val digit = (powerLevel / 100) % 10
        return digit - 5
    }

    fun locateHighestChargedCell(squareSize: Int): Triple<Int, Int, Int> {
        var highestChargedCell = Triple(0 ,0, 0)
        for (x in 1 .. 300 - squareSize) {
            for (y in 1 .. 300 - squareSize) {
                val currentValue = getCellTotalPower(x, y, squareSize)
                if (currentValue > highestChargedCell.third) {
                    highestChargedCell = Triple(x, y, currentValue)
                }
            }
        }

        return highestChargedCell
    }

    fun locateHighestChargedCellOfAnySize(): Triple<Int, Int, Int> {
        var bestSize = 0
        var bestSquare = Triple(0, 0, Int.MIN_VALUE)
        for (size in 1 .. 300) {
            val (x, y, power)  = locateHighestChargedCell(size)
            if (power >= bestSquare.third) {
                bestSquare = Triple(x, y, power)
                bestSize = size
            } else {
                // We're not going to find a better solution than the previous one
                return Triple(bestSquare.first, bestSquare.second, bestSize)
            }
        }
        return Triple(bestSquare.first, bestSquare.second, bestSize)
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
    val fuelCells = FuelCells(5177)

    val (x3, y3, _) = fuelCells.locateHighestChargedCell(3)
    println("Solution to the first part is $x3,$y3")

    val (x, y, size) = fuelCells.locateHighestChargedCellOfAnySize()
    println("Solution to the second part is $x,$y,$size")
}
