package com.github.christopheml.day01

import java.lang.IllegalArgumentException

class Calibration(private val frequencies: String) {

    fun frequency(): Int {
        val sign = frequencies[0]
        val value = frequencies.substring(1).toInt()
        return when (sign) {
            '+' ->  value
            '-' -> -value
            else -> throw IllegalArgumentException("Malformed frequency [$frequencies]")
        }
    }

}
