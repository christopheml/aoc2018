package com.github.christopheml.day02

internal class WordDifferences {

    fun count(word: String, other: String): Int {
        return word.indices.count { word[it] != other[it] }
    }

    fun common(word: String, other: String): String {
        return word.filterIndexed { index, c -> other[index] == c }
    }

}
