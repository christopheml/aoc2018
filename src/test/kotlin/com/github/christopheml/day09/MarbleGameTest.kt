package com.github.christopheml.day09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MarbleGameTest {

    companion object {
        @JvmStatic
        fun test_cases(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(9, 32, 32),
                Arguments.of(10, 1618, 8317),
                Arguments.of(13, 7999, 146373),
                Arguments.of(17, 1104, 2764),
                Arguments.of(21, 6111, 54718),
                Arguments.of(30, 5807, 37305)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    internal fun reactions(playerCount: Int, lastMarbleScore: Int, expectedHighScore: Int) {
        val game = MarbleGame(playerCount)
        val scores = game.playUntil(lastMarbleScore)
        assertThat(scores.max()!!).isEqualTo(expectedHighScore)
    }

}
