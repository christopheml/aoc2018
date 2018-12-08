package com.github.christopheml.day08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TreeBuilderTest {

    @Test
    internal fun acceptance_test() {
        val input = listOf(2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2)
        val treeBuilder = TreeBuilder(input)
        val tree = treeBuilder.build()
        assertThat(tree.sumOfAllMetadata()).isEqualTo(138)
    }

}
