package com.github.christopheml.day07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrerequisitesTest {

    @Test
    internal fun acceptance_test() {
        val prerequisites = Prerequisites()

        prerequisites.add('A', 'C')
        prerequisites.add('F', 'C')
        prerequisites.add('B', 'A')
        prerequisites.add('D', 'A')
        prerequisites.add('E', 'B')
        prerequisites.add('E', 'D')
        prerequisites.add('E', 'F')

        assertThat(prerequisites.order()).isEqualTo("CABDFE")
    }

}
