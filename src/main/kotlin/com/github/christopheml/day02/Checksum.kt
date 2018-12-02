package com.github.christopheml.day02

import com.github.christopheml.common.PuzzleInput

internal class Checksum(private val words: List<String>) {

    fun calculate(): Int {
        val letterFilter = LetterFilter()
        val sum2 = words.count { w -> letterFilter.containsNOfAnyLetter(w, 2) }
        val sum3 = words.count { w -> letterFilter.containsNOfAnyLetter(w, 3) }

        return sum2 * sum3
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput("day02.txt").asList()
    val checksum = Checksum(input)
    println("Solution for first part is " + checksum.calculate())
}
