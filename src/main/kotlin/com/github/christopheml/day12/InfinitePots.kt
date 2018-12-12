package com.github.christopheml.day12

import com.github.christopheml.common.PuzzleInput
import java.util.*

class InfinitePots(initialState: String, textPatterns: List<String>) {

    private val pots: MutableList<PotContent> = ArrayList(toPotContents(initialState))

    private val patterns = parsePatterns(textPatterns)

    private var offset = 0

    private fun <T: Any>List<T>.startsWith(other: List<T>): Boolean {
        return other.indices.all { this[it] == other[it] }
    }

    private fun <T: Any>List<T>.endsWith(other: List<T>): Boolean {
        return other.indices.all { this[size - other.size + it] == other[it] }
    }

    fun generation() {
        expandIfNecessary()

        val potsWithPlants = HashSet<Int>()
        for (i in 2 until pots.size - 2) {
            val slice = pots.subList(i - 2, i + 3)
            if (patterns.contains(slice)) {
                potsWithPlants.add(i)
            }
        }

        pots.indices.forEach {
            pots[it] = when {
                potsWithPlants.contains(it) -> PotContent.PLANT
                else -> PotContent.EMPTY
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
        val padding = PotContent.EMPTY.times(3)

        while (!pots.startsWith(padding)) {
            expandLeft()
        }

        while (!pots.endsWith(padding)) {
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

    fun fingerprint(): Int {
        return pots.subList(pots.indexOfFirst { it == PotContent.PLANT }, pots.indexOfLast { it == PotContent.PLANT } + 1).hashCode()
    }

    fun render(): String {
        return pots.map { it.toChar() }.joinToString("")
    }

    private fun parsePatterns(textPatterns: List<String>): Set<List<PotContent>> {
        return textPatterns
            .filter { s -> s.endsWith('#') }
            .map { toPotContents(it.substring(0, 5)) }
            .toSet()
    }

    private fun toPotContents(text: String): List<PotContent> = text.map { toPotContent(it) }

    private fun toPotContent(it: Char) = if (it == '#') PotContent.PLANT else PotContent.EMPTY

}

fun main(args: Array<String>) {
    val input = PuzzleInput(12).asList()
    val initial = input[0].removePrefix("initial state: ")
    val textPatterns = input.subList(1, input.size)

    val pots = InfinitePots(initial, textPatterns)

    var generation = 0L

    for (i in 1..20) {
        pots.generation()
        generation++
    }

    val part1Result = pots.computeResult()

    val seen = HashSet<Int>()
    var part2Result = 0L

    var sum = 0
    var delta = 0
    do {
        pots.generation()
        val fingerprint = pots.fingerprint()

        if (seen.contains(fingerprint)) {
            delta = pots.computeResult() - sum
            part2Result = pots.computeResult().toLong()
            println("Cycle detected at generation $generation, delta is $delta, base value is $part2Result")
            break
        }
        seen.add(fingerprint)
        sum = pots.computeResult()
        generation++
    } while (generation < 50000000000)

    val remainingIterations = 50000000000 - generation - 1
    part2Result += remainingIterations * delta

    println("Solution for first part is $part1Result")
    println("Solution for second part is $part2Result")
}
