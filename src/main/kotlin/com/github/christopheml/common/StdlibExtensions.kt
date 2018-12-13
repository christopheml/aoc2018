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
