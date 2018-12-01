package com.github.christopheml.day01

class Calibration(textFrequencies: List<String>) {

    private val frequencies: List<Frequency> = textFrequencies.map { f -> Frequency(f) }

    fun frequency(): Int {
        return frequencies.map { f -> f.value }.sum()
    }

}
