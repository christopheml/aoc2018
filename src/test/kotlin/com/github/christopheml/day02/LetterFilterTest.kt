package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LetterFilterTest {

    @ParameterizedTest
    @ValueSource(strings = ["bababc", "abbcde", "aabcdd", "abcdee"])
    internal fun words_containing_two_of_any_letter(word: String) {
        val letterFilter = LetterFilter()
        assertThat(letterFilter.containsNOfAnyLetter(word, 2)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["bababc", "abcccd", "ababab"])
    internal fun words_containing_three_of_any_letter(word: String) {
        val letterFilter = LetterFilter()
        assertThat(letterFilter.containsNOfAnyLetter(word, 3)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "abbcde", "aabcdd", "abcdee"])
    internal fun words_not_containing_three_of_any_letter(word: String) {
        val letterFilter = LetterFilter()
        assertThat(letterFilter.containsNOfAnyLetter(word, 3)).isFalse()
    }

}
