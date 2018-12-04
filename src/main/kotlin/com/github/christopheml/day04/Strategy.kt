package com.github.christopheml.day04

import com.github.christopheml.common.PuzzleInput

fun main(args: Array<String>) {
    val input = PuzzleInput("day04.txt").asList()
    val shifts = Shifts(ShiftParser(input).parse().values)

    val mostAsleepGuard = shifts.mostAsleepGuard()
    val solution = mostAsleepGuard * shifts.mostAsleepMinuteForGuard(mostAsleepGuard)

    println("Solution to first part is $solution")
}
