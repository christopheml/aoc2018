package com.github.christopheml.day01

class Calibration(private val frequencies: String) {

    fun frequency(): Int {
        return frequencies.substring(1).toInt()
    }

}
