package com.github.christopheml.day25

import com.github.christopheml.common.PuzzleInput

class ConstellationMapper(private val coordinates: List<Coordinate>) {

    fun map(): Int {
        for (i in 0 until coordinates.size) {
            val candidate = coordinates.first { it.constellation == -1 }
            val mappedAndClose = coordinates.filter { it.constellation != -1 && it.distanceFrom(candidate) <= 3 }
            candidate.constellation = i
            if (!mappedAndClose.isEmpty()) {
                val closeConstellations = mappedAndClose.map { it.constellation }
                coordinates
                    .filter { closeConstellations.contains(it.constellation) }
                    .forEach { it.constellation = i }
            }
        }

        return coordinates.map { it.constellation }.distinct().count()
    }

}

fun main(args: Array<String>) {
    val mapper = ConstellationMapper(PuzzleInput(25).asList().map { parse(it) })
    val part1 = mapper.map()
    println("Solution to the first part is $part1")
}
