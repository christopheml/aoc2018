package com.github.christopheml.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PolymerTest {

    companion object {
        @JvmStatic
        fun test_cases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("aA", ""),
                Arguments.of("abBA", ""),
                Arguments.of("abAB", "abAB"),
                Arguments.of("aabAAB", "aabAAB"),
                Arguments.of("dabAcCaCBAcCcaDA", "dabCBAcaDA")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    internal fun reactions(chain: String, polymerized: String) {
        assertThat(Polymer(chain).react()).isEqualTo(polymerized)
    }

}

