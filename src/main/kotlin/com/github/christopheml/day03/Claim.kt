package com.github.christopheml.day03

internal class Claim(internal val id: String, private val origin: Pair<Int, Int>, private val size: Pair<Int, Int>) {

    fun points(): Sequence<Pair<Int, Int>> {
        return iterator {
            for (x in 0 until size.first) {
                for (y in 0 until size.second) {
                    yield(Pair(x + origin.first, y + origin.second))
                }
            }
        }.asSequence()
    }

}
