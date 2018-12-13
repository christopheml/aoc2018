package com.github.christopheml.day13

enum class Direction {

    TOP, RIGHT, BOTTOM, LEFT;

    fun left(): Direction {
        return when (this) {
            TOP -> LEFT
            RIGHT -> TOP
            BOTTOM -> RIGHT
            LEFT -> BOTTOM
        }
    }

    fun opposite(): Direction {
        return left().left()
    }

    fun right(): Direction {
        return left().left().left()
    }

}
