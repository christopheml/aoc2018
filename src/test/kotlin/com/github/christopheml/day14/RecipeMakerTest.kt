package com.github.christopheml.day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

internal class RecipeMakerTest {

    @TestFactory
    internal fun part1_acceptance_test() = listOf(
        9 to "5158916779",
        5 to "0124515891",
        18 to "9251071085",
        2018 to "5941429882"
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("After $input recipes, last ten are $expected") {
            val recipeMaker = RecipeMaker(listOf(3, 7))
            val result = recipeMaker.runFor(input)
            assertThat(result).isEqualTo(expected)
        }
    }

    @TestFactory
    internal fun part2_acceptance_test() = listOf(
        "51589" to 9,
        "01245" to 5,
        "92510" to 18,
        "59414" to 2018
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("$input first appears after $expected recipes") {
            val recipeMaker = RecipeMaker(listOf(3, 7))
            val result = recipeMaker.runUntilSequence(input)
            assertThat(result).isEqualTo(expected)
        }
    }

}
