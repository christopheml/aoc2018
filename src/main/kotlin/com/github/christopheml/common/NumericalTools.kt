package com.github.christopheml.common

fun boundaries(values: Iterable<Int>): Pair<Int, Int> {
    // A more efficient method is possible but this is the most concise way I found
    val sortedValues = values.sorted()
    return Pair(sortedValues.first(), sortedValues.last())
}
