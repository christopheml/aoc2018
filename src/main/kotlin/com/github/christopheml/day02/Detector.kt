package com.github.christopheml.day02

import com.github.christopheml.common.PuzzleInput
import java.lang.IllegalStateException

internal class Detector(private val words: List<String>) {

    fun find(): String {
        val wordDifferences = WordDifferences()

        for (i in words.indices) {
            for (j in i + 1 until words.size) {
                if (wordDifferences.count(words[i], words[j]) == 1) {
                    return wordDifferences.common(words[i], words[j])
                }
            }
        }

        throw IllegalStateException("Nothing found :(")
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput(2).asList()
    val detector = Detector(input)
    println("Solution to second part is " + detector.find())
}
