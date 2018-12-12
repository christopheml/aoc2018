package com.github.christopheml.day12

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InfinitePotsTest {

    @Test
    internal fun acceptance_test() {
        val textPatterns = listOf(
            "...## => #",
            "..#.. => #",
            ".#... => #",
            ".#.#. => #",
            ".#.## => #",
            ".##.. => #",
            ".#### => #",
            "#.#.# => #",
            "#.### => #",
            "##.#. => #",
            "##.## => #",
            "###.. => #",
            "###.# => #",
            "####. => #"
        )

        val pots = InfinitePots("#..#.#..##......###...###", textPatterns)

        for (i in 1..20) {
            pots.generation()
            println(pots.render())
        }

        assertThat(pots.render()).contains(".#....##....#####...#######....#.#..##.")
        assertThat(pots.computeResult()).isEqualTo(325)
    }

}
