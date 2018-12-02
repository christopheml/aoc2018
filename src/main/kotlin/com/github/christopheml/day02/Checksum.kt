package com.github.christopheml.day02

internal class Checksum(private val words: List<String>) {

    fun calculate(): Int {
        var sum2 = 0
        var sum3 = 0
        val letterFilter = LetterFilter()

        for (word in words) {
            if (letterFilter.containsNOfAnyLetter(word, 2)) {
                sum2++
            }
            if (letterFilter.containsNOfAnyLetter(word, 3)) {
                sum3++
            }
        }

        return sum2 * sum3
    }

}
