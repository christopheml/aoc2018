package com.github.christopheml.common

class PuzzleInput(private val day: Int) {

    fun asList(): List<String> {
        return PuzzleInput::class.java.getResource("/puzzle_inputs/day%02d.txt".format(day)).readText()
            .lines()
            .filter { s -> s.isNotBlank() }
    }

    fun asString(): String {
        return asList()[0]
    }

}
