package com.github.christopheml.day13

import kotlin.random.Random

class Cart(initialDirection: Char, var position: Track) {

    private var id = Random.nextInt(0, 100)

    private val directionChanges = listOf(
        this::turnLeft,
        this::goForward,
        this::turnRight
    )

    private var direction = when (initialDirection) {
        '>' -> Direction.RIGHT
        '<' -> Direction.LEFT
        'v' -> Direction.BOTTOM
        '^' -> Direction.TOP
        else -> throw IllegalArgumentException("$initialDirection is an invalid direction")
    }

    private var counter = 0

    fun move() {
        val directions = position.directions()
        if (directions.size == 4) {
            directionChanges[counter % 3].invoke()
            counter++
        } else {
            direction = directions.first { it != direction.opposite() }
        }
        position = position.next(direction)
    }

    private fun turnLeft() {
        direction = direction.left()
    }

    private fun turnRight() {
        direction = direction.right()
    }

    private fun goForward() = Unit

}
