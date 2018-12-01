package com.github.christopheml.day01

import com.github.christopheml.common.PuzzleInput

class Calibration(textFrequencies: List<String>) {

    private val frequencies: List<Frequency> = textFrequencies.map { f -> Frequency(f) }

    fun frequency(): Int {
        return frequencies.map { f -> f.value }.sum()
    }

    fun firstReachedTwiceFrequency(): Int {
        val reachedFrequencies: MutableSet<Int> = HashSet()
        var currentFrequency = 0
        var index = 0
        while (true) {
            currentFrequency += frequencies[index % frequencies.size].value
            if (reachedFrequencies.contains(currentFrequency)) {
                return currentFrequency
            }
            reachedFrequencies.add(currentFrequency)
            index++
        }
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput("day01.txt").asList()
    val calibration = Calibration(input)
    println("Solution for first part is " + calibration.frequency())
    println("Solution for second part is " + calibration.firstReachedTwiceFrequency())
}
