package com.github.christopheml.day09

internal class Marbles {

    private val marbles = CircularList<Long>(0)
    private var marbleNumber: Long = 0

    fun play(): Long {
        marbleNumber++
        return if (marbleNumber % 23 == 0L) {
            marbles.goCounterclockwise(7)
            val removed = marbles.remove()
            removed + marbleNumber
        } else {
            marbles.goClockwise(1)
            marbles.insertAfter(marbleNumber)
            0
        }
    }

    fun representation(): String {
        return marbles.toList()
            .joinToString(" ") {
                if (it == marbles.currentValue()) "($it)" else it.toString()
            }
    }

}
