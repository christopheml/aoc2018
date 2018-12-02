package com.github.christopheml.day02

internal class Checksum(private val words: List<String>) {

    fun calculate(): Int {
        val letterFilter = LetterFilter()
        val sum2 = words.count { w -> letterFilter.containsNOfAnyLetter(w, 2) }
        val sum3 = words.count { w -> letterFilter.containsNOfAnyLetter(w, 3) }

        return sum2 * sum3
    }

}
