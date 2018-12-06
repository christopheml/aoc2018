package com.github.christopheml.day05

import com.github.christopheml.common.PuzzleInput

class PolymerExplorer(private val chain: String) {

    fun explore(): Int {
        return "abcdefghijklmnopqrstuvwxyz"
            .map { c -> strip(chain, c) }
            .map { s -> Polymer(s) }
            .map { p -> p.react() }
            .map { s -> s.length }
            .min()!!
    }

    private fun strip(s: String, toStrip: Char): String {
        return s.filter { c -> c != toStrip && c != toStrip.toUpperCase() }
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput(5).asString()
    val minimumSize = PolymerExplorer(input).explore()

    println("Solution to the second part is $minimumSize.")
}
