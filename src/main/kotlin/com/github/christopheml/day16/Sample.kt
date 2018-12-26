package com.github.christopheml.day16

import com.github.christopheml.common.PuzzleInput

class Sample(private val before: List<Int>, private val instruction: List<Int>, private val after: List<Int>) {

    fun matches(instructions: List<Instruction>): Int {
        val (opcode, a, b, c) = instruction
        return instructions
            .map { it.execute(before, a, b, c) }
            .filter { it == after }
            .count()
    }

}

fun main(args: Array<String>) {
    val instructions = allInstructions()
    val inputs = PuzzleInput(16).asList().iterator()
    val samples = ArrayList<Sample>()
    while (inputs.hasNext()) {
        val firstLine = inputs.next()
        if (!firstLine.startsWith("Before")) {
            break
        }
        val before = firstLine.removeSurrounding("Before: [", "]").split(", ").map { it.toInt() }
        val instruction = inputs.next().split(" ").map { it.toInt() }
        val after = inputs.next().removeSurrounding("After:  [", "]").split(", ").map { it.toInt() }
        samples.add(Sample(before, instruction, after))
    }

    val part1 = samples.map { it.matches(instructions) }.filter { it >= 3 }.count()
    println("Solution to the first part is $part1")
}
