package com.github.christopheml.day01

class Calibration(frequencies: String) {

    private val frequency: Frequency = Frequency(frequencies)

    fun frequency(): Int {
        return frequency.value
    }

}
