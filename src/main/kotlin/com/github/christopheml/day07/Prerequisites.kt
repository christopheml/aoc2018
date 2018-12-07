package com.github.christopheml.day07

import com.github.christopheml.common.PuzzleInput

class Prerequisites {

    private val prerequisites = HashMap<Char, MutableList<Char>>()

    fun add(step: Char, requires: Char) {
        prerequisites.putIfAbsent(step, ArrayList())
        prerequisites.putIfAbsent(requires, ArrayList())
        prerequisites[step]!!.add(requires)
    }

    fun order(): String {
        val done = ArrayList<Char>()

        while (done.size < prerequisites.size) {
            val nextStep = prerequisites
                .filterValues { v -> v.minus(done).isEmpty() }
                .keys
                .minus(done)
                .sorted()
                .first()

            done.add(nextStep)
        }

        return done.joinToString("")
    }

}

fun main(args: Array<String>) {
    val prerequisites = Prerequisites()
    PuzzleInput(7).asList()
        .forEach { line ->
            prerequisites.add(
                line.substring(36, 37).first(), line.substring(5, 6).first()
            )
        }
    println("Solution to the first part is: " + prerequisites.order())
}
