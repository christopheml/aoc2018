package com.github.christopheml.day02

class LetterFilter {

    fun containsNOfAnyLetter(word: String, n: Int): Boolean {
        return word.groupingBy { k -> k }.eachCount().containsValue(n)
    }

}
