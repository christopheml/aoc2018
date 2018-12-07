package com.github.christopheml.day06

import java.lang.IllegalStateException

class Elves(private val count: Int) {

    private val assignments = HashMap<Char, Int>()

    fun isAvailable(): Boolean {
        return assignments.size < count
    }

    fun assign(step: Char, time: Int) {
        if (!isAvailable()) {
            throw IllegalStateException("No elf available!")
        }
        assignments[step] = time
    }

    fun assigned(): Collection<Char> {
        return assignments.keys
    }

    fun tick(): List<Char> {
        // FIXME Replace this with idiomatic Kotlin
        for (entry in assignments) {
            if (entry.value > 0) {
                assignments[entry.key] = entry.value - 1
            }
        }

        val done = assignments.filterValues { it == 0 }.keys
        done.forEach { assignments.remove(it) }
        return done.toList()
    }

}
