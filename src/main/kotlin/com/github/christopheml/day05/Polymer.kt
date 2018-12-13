package com.github.christopheml.day05

import com.github.christophem.common.xorCase
import com.github.christopheml.common.PuzzleInput
import java.util.*

internal class Polymer(private val chain: String) {

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

}

fun main(args: Array<String>) {
    val input = PuzzleInput(5).asString()
    val polymerized = Polymer(input).react()

    println("Solution to the first part is " + polymerized.length)
}
