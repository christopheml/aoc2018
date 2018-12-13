package com.github.christopheml.day13

import com.github.christopheml.common.Point
import com.github.christopheml.common.PuzzleInput
import java.util.*

class Tracks(input: List<String>) {

    private val trackGrid = input.map { it.toCharArray() }.toTypedArray()

    private val tracks = createTracks()

    private val carts = ArrayList<Cart>()

    init {
        linkTracks()
    }

    fun simulate(): Point {
        do {
            carts.forEach { it.move() }
            val collisions = carts.map { it.position }.groupingBy { it }.eachCount().filter { it.value == 2 }
            if (collisions.isNotEmpty()) {
                return collisions.keys.first().position
            }
        } while (true)
    }

    fun highlander(): Point {
        do {
            carts.forEach { it.move() }
            val crashed = carts
                .groupBy { it.position }
                .filterValues { it.size > 1 }
                .values
                .flatten()
            carts.removeAll(crashed)
        } while (carts.size > 1)
        return carts.first().position.position
    }

    private fun readGrid(x: Int, y: Int): Char {
        return trackGrid.getOrNull(y)?.getOrNull(x) ?: ' '
    }

    private fun linkTracks() {
        tracks.forEach {

            val current = readGrid(it.position.x, it.position.y)
            if ("><v^".contains(current)) {
                carts.add(Cart(current, it))
            }

            val top = toTrackType(readGrid(it.position.x, it.position.y - 1))
            val bottom = toTrackType(readGrid(it.position.x, it.position.y + 1))
            val left = toTrackType(readGrid(it.position.x - 1, it.position.y))
            val right = toTrackType(readGrid(it.position.x + 1, it.position.y))

            if (it.type == TrackType.HORIZONTAL) {
                linkHorizontal(it)
            } else if (it.type == TrackType.VERTICAL) {
                linkVertical(it)
            } else if (it.type == TrackType.INTERSECTION) {
                linkHorizontal(it)
                linkVertical(it)
            } else if (it.type == TrackType.CORNER_SLASH) {
                if (top.isVertical() && left.isHorizontal()) {
                    linkTop(it)
                    linkLeft(it)
                } else if (bottom.isVertical() && right.isHorizontal()) {
                    linkBottom(it)
                    linkRight(it)
                }
            } else if (it.type == TrackType.CORNER_BACKSLASH) {
                if (top.isVertical() && right.isHorizontal()) {
                    linkTop(it)
                    linkRight(it)
                } else if (bottom.isVertical() && left.isHorizontal()) {
                    linkBottom(it)
                    linkLeft(it)
                }
            }
        }
    }

    private fun linkVertical(it: Track) {
        linkTop(it)
        linkBottom(it)
    }

    private fun linkHorizontal(it: Track) {
        linkLeft(it)
        linkRight(it)
    }

    private fun linkBottom(it: Track) {
        it.link(Direction.BOTTOM, getTrack(it.position.x, it.position.y + 1))
    }

    private fun linkTop(it: Track) {
        it.link(Direction.TOP, getTrack(it.position.x, it.position.y - 1))
    }

    private fun linkRight(it: Track) {
        it.link(Direction.RIGHT, getTrack(it.position.x + 1, it.position.y))
    }

    private fun linkLeft(it: Track) {
        it.link(Direction.LEFT, getTrack(it.position.x - 1, it.position.y))
    }

    private fun getTrack(x: Int, y: Int): Track {
        return tracks.find { it.position.x == x && it.position.y == y }!!
    }

    private fun createTracks(): ArrayList<Track> {
        val tracks = ArrayList<Track>()
        trackGrid.indices.forEach { y ->
            trackGrid[y].indices.forEach { x ->
                val trackType = toTrackType(trackGrid[y][x])
                if (trackType != TrackType.NO_TRACK) {
                    tracks.add(Track(trackType, Point(x, y)))
                }
            }
        }
        return tracks
    }

}

fun main(args: Array<String>) {
    part1()
    part2()
}

private fun part2() {
    val tracks = Tracks(PuzzleInput(13).asList())
    val (x, y) = tracks.highlander()
    println("Solution to the second part is $x,$y")
}

private fun part1() {
    val tracks = Tracks(PuzzleInput(13).asList())
    val (x, y) = tracks.simulate()
    println("Solution to the first part is $x,$y")
}
