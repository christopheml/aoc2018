package com.github.christopheml.day01

import java.lang.IllegalArgumentException

class Frequency(textFrequency: String) {

    val value: Int

    init {
        value = toInteger(textFrequency)
    }

    private fun toInteger(textFrequency: String): Int {
        val sign = textFrequency[0]
        val value = textFrequency.substring(1).toInt()
        return when (sign) {
            '+' ->  value
            '-' -> -value
            else -> throw IllegalArgumentException("Malformed frequency [$textFrequency]")
        }
    }

}
