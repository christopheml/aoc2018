package com.github.christopheml.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChecksumTest {

    @Test
    internal fun acceptance_test() {
        val checksum = Checksum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))
        assertThat(checksum.calculate()).isEqualTo(12)
    }

}
