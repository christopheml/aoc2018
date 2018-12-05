package com.github.christopheml.common

class PuzzleInput(private val filename: String) {

    fun asList(): List<String> {
        return PuzzleInput::class.java.getResource("/puzzle_inputs/$filename").readText()
            .lines()
            .filter { s -> s.isNotBlank() }
    }

    fun asString(): String {
        return asList()[0]
    }

}
