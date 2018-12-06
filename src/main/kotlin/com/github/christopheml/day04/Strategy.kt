package com.github.christopheml.day04

import com.github.christopheml.common.PuzzleInput

fun main(args: Array<String>) {
    val input = PuzzleInput(4).asList()
    val shifts = Shifts(ShiftParser(input).parse())

    val mostAsleepGuard = shifts.mostAsleepGuard()
    val solution = mostAsleepGuard * shifts.mostAsleepMinuteForGuard(mostAsleepGuard).first

    println("Solution to first part is $solution")

    val (guard, mostAsleepMinute) = shifts.guards()
        .associateBy({ it }, { shifts.mostAsleepMinuteForGuard(it) })
        .maxBy { e -> e.value.second }!!

    println("Solution to second part is " + guard * mostAsleepMinute.first)

}
