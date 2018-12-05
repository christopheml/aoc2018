package com.github.christopheml.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PolymerExplorerTest {

    @Test
    internal fun acceptance_test() {
        val polymerExplorer = PolymerExplorer("dabAcCaCBAcCcaDA")
        assertThat(polymerExplorer.explore()).isEqualTo(4)
    }

}
