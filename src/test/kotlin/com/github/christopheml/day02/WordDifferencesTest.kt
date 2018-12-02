package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WordDifferencesTest {

    @Test
    internal fun no_difference() {
        val wordDifferences = WordDifferences()
        assertThat(wordDifferences.count("hello", "hello")).isEqualTo(0)
    }

    @Test
    internal fun several_differences() {
        val wordDifferences = WordDifferences()
        assertThat(wordDifferences.count("woop woop", "woup woup")).isEqualTo(2)
    }

    @Test
    internal fun common_characters() {
        val wordDifferences = WordDifferences()
        assertThat(wordDifferences.common("hello", "hallo")).isEqualTo("hllo")
    }

}
