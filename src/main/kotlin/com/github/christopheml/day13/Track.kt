package com.github.christopheml.day13

import com.github.christopheml.common.Point
import java.util.*

class Track(val type: TrackType, val position: Point) {

    private val connections = EnumMap<Direction, Track>(Direction::class.java)


    fun link(direction: Direction, other: Track) {
        connections[direction] = other
    }

}

