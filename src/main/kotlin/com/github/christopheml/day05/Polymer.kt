package com.github.christopheml.day05

import com.github.christopheml.common.PuzzleInput
import java.util.*

internal class Polymer(private val chain: String) {

    private val reductionRegex = generateRegex()

    private fun Char.xorCase(other: Char): Boolean {
        return isLowerCase() && other.isUpperCase() || isUpperCase() && other.isLowerCase()
    }

    fun react(): String {
        val polymerized = ArrayDeque<Char>(chain.length)
        for (c in chain) {
            if (polymerized.isNotEmpty()) {
                val last = polymerized.peek()
                if (last.xorCase(c) && last.equals(c, ignoreCase = true)) {
                    polymerized.pop()
                    continue
                }
            }
            polymerized.push(c)
        }
        return polymerized.joinToString("").reversed()
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
