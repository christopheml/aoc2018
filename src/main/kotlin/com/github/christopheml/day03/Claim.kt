package com.github.christopheml.day03

internal class Claim(private val origin: Pair<Int, Int>, private val size: Pair<Int, Int>) {

    fun points(): List<Pair<Int, Int>> {
        val points = ArrayList<Pair<Int, Int>>()
        for (x in 0 until size.first) {
            for (y in 0 until size.second) {
                points.add(Pair(x + origin.first, y + origin.second))
            }
        }
        return points
    }

}
