package com.github.christopheml.day09

import java.util.*

internal class Marbles(size: Int = 10000000) {

    private val marbles = ArrayList<Int>()
    private var marbleNumber = 0
    private var currentMarblePosition = 0

    init {
        marbles.add(0)
    }

    fun play(): Int {
        val insertPosition = insertPosition()
        val removePosition = currentMarblePosition - 7
        marbleNumber++
        return if (marbleNumber % 23 == 0) {
            val removed = remove(removePosition)
            marbleNumber + removed
        } else {
            insert(insertPosition, marbleNumber)
            0
        }
    }

    private fun remove(position: Int): Int {
        val removalPosition = circular(position)
        val value = marbles[removalPosition]
        marbles.remove(value)
        currentMarblePosition = circular(removalPosition)
        return value
    }

    private fun circular(position: Int) = (position + marbles.size) % marbles.size

    fun representation(): String {
        return marbles
            .joinToString(" ") {
                if (it == marbles[currentMarblePosition]) "($it)" else it.toString()
            }
    }

    private fun insertPosition(): Int {
        val position = when (marbleNumber) {
            0, 1 -> 1
            else -> currentMarblePosition + 2
        }

        return if (position < marbles.size + 1) {
            position
        } else {
            (position % marbles.size)
        }
    }


    private fun insert(position: Int, value: Int) {
        marbles.add(position, value)
        currentMarblePosition = position
    }

}
