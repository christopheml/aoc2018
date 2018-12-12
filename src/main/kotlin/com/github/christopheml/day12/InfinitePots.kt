package com.github.christopheml.day12

import com.github.christopheml.common.PuzzleInput
import java.util.*

class InfinitePots(initialState: String, textPatterns: List<String>) {

    private val pots: MutableList<PotContent> = ArrayList(toPotContents(initialState))

    private val patterns = parsePatterns(textPatterns)

    private var offset = 0

    fun generation() {
        expandIfNecessary()

        val newPlants = pots.mapIndexed { index, _ ->
            if (patterns.any { matches(index, it.matcher) }) index else null
        }.filterNotNull().toSet()

        pots.indices.forEach {
            if (newPlants.contains(it)) {
                pots[it] = PotContent.PLANT
            } else {
                pots[it] = PotContent.EMPTY
            }
        }
    }

    fun computeResult(): Int {
        return pots
            .mapIndexed { index, potContent -> if (potContent == PotContent.PLANT) index else null }
            .filterNotNull()
            .map { toPotNumber(it) }
            .sum()
    }

    private fun toPotNumber(index: Int): Int {
        return index - offset
    }

    private fun expandIfNecessary() {
        if (pots[0] == PotContent.PLANT) {
            expandLeft()
            expandLeft()
        } else if (pots[0] == PotContent.EMPTY && pots[1] == PotContent.PLANT) {
            expandLeft()
        }
        if (pots[pots.size - 1] == PotContent.PLANT) {
            expandRight()
            expandRight()
        } else if (pots[pots.size - 1] == PotContent.EMPTY && pots[pots.size - 2] == PotContent.PLANT) {
            expandRight()
        }
    }

    private fun expandLeft() {
        pots.add(0, PotContent.EMPTY)
        offset++
    }

    private fun expandRight() {
        pots.add(PotContent.EMPTY)
    }

    fun render(): String {
        return pots.map { it.toChar() }.joinToString("")
    }

    private fun parsePatterns(textPatterns: List<String>): List<PotPattern> {
        return textPatterns
            .filter { s -> s.endsWith('#') }
            .map {
                PotPattern(
                    toPotContents(it.substring(0, 5)),
                    toPotContent(it.last())
                )
            }
    }

    private fun matches(start: Int, matcher: List<PotContent>): Boolean {
        return IntRange(0, 4).all { pots.getOrNull(start + it - 2) ?: PotContent.EMPTY == matcher[it] }
    }

    private fun toPotContents(text: String): List<PotContent> = text.map { toPotContent(it) }

    private fun toPotContent(it: Char) = if (it == '#') PotContent.PLANT else PotContent.EMPTY

}

fun main(args: Array<String>) {
    val input = PuzzleInput(12).asList()
    val initial = input[0]
    val textPatterns = input.subList(1, input.size)

    val pots = InfinitePots(initial, textPatterns)

    for (i in 1..20) {
        pots.generation()
    }

    println("Solution for first part is " + pots.computeResult())
}
