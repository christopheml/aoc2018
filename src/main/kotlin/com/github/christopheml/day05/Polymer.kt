package com.github.christopheml.day05

import com.github.christopheml.common.PuzzleInput

internal class Polymer(private val chain: String) {

    private val reductionRegex = generateRegex()

    fun react(): String {
        var reduced = chain
        var length: Int

        do {
            length = reduced.length
            reduced = reduced.replaceFirst(reductionRegex, "")
        } while (length != reduced.length)

        return reduced
    }

    private fun generateRegex(): Regex {
        val leftToRight = "abcdefghijklmnopqrstuvwxyz".map { c -> c.toString() + c.toUpperCase() }
        val rightToLeft = leftToRight.map { w -> w.reversed() }
        return Regex((leftToRight + rightToLeft).joinToString("|"))
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput("day05.txt").asString()
    val polymerized = Polymer(input).react()

    println("Solution to the first part is " + polymerized.length)
}
