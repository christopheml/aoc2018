package com.github.christopheml.day14

import com.github.christophem.common.indexOfList

class RecipeMaker(initial: List<Int>) {

    private val recipes = initial.toMutableList()

    var elf1 = 0
    var elf2 = 1

    fun runFor(n: Int): String {
        while (recipes.size < 10 + n) {
            update()
        }
        return scoreOfLastTen(n)
    }

    fun runUntilSequence(s: String): Int {
        val sequence = s.map { it.toString().toInt() }
        while (true) {
            update()
            val snippet = recipes.takeLast(10)
            val position = snippet.indexOfList(sequence)
            if (position > -1) {
                return recipes.size - 10 + position
            }
        }
    }

    private fun update() {
        generateRecipes()
        elf1 = forward(elf1)
        elf2 = forward(elf2)
    }

    private fun generateRecipes() {
        val newRecipe = recipes[elf1] + recipes[elf2]
        if (newRecipe < 10) {
            recipes.add(newRecipe)
        } else {
            recipes.add(newRecipe / 10)
            recipes.add(newRecipe % 10)
        }
    }

    private fun scoreOfLastTen(after: Int): String {
        return recipes.subList(after, after + 10).joinToString("")
    }

    private fun forward(elf: Int): Int {
        return (elf + 1 + recipes[elf]) % recipes.size
    }

}

fun main(args: Array<String>) {
    var part1 = RecipeMaker(listOf(3, 7)).runFor(919901)
    println("Solution for the first part is $part1")

    var part2 = RecipeMaker(listOf(3, 7)).runUntilSequence("919901")
    println("Solution for the second part is $part2")
}
