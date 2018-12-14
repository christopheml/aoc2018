package com.github.christopheml.common

import com.github.christophem.common.containsList
import com.github.christophem.common.indexOfList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StdlibExtensionsTest {

    @Test
    internal fun contains() {
        assertThat(listOf(8, 3, 0, 4, 6).containsList(listOf(0, 4))).isTrue()
        assertThat(listOf(8, 3, 0, 4, 6).containsList(listOf(8, 3, 0))).isTrue()
        assertThat(listOf(8, 3, 0, 4, 6).containsList(listOf(8))).isTrue()
        assertThat(listOf(8, 3, 0, 4, 6).containsList(listOf(3, 4))).isFalse()
        assertThat(listOf(8, 8, 8, 8, 3, 0, 4, 6).containsList(listOf(8, 3, 0, 4, 6))).isTrue()
    }

    @Test
    internal fun indexOf() {
        assertThat(listOf(1, 2, 3).indexOfList(listOf(8, 9))).isEqualTo(-1)
        assertThat(listOf(1, 2, 3).indexOfList(listOf(2, 3, 4))).isEqualTo(-1)
        assertThat(listOf(1, 2, 3).indexOfList(listOf(2, 3))).isEqualTo(1)
        assertThat(listOf(1, 2, 3).indexOfList(listOf(3))).isEqualTo(2)
    }

}
