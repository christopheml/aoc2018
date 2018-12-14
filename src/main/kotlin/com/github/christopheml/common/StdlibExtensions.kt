package com.github.christophem.common

fun Char.xorCase(other: Char): Boolean {
    return isLowerCase() && other.isUpperCase() || isUpperCase() && other.isLowerCase()
}

fun <T : Any> List<T>.startsWith(other: List<T>): Boolean {
    return other.indices.all { this[it] == other[it] }
}

fun <T : Any> List<T>.endsWith(other: List<T>): Boolean {
    return other.indices.all { this[size - other.size + it] == other[it] }
}

fun <T : Any> List<T>.containsList(other: List<T>): Boolean {
    // This is a naive implementation without skip logic, but it should be sufficient
    return indexOfList(other) > -1
}

fun <T : Any> List<T>.indexOfList(other: List<T>): Int {
    return indices
        .filter { this[it] == other.first() }
        .filter { it + other.size <= size }
        .firstOrNull { offset -> other.indices.all { this[offset + it] == other[it] } }
        ?: -1
}
