package com.github.christopheml.day13

import com.github.christopheml.common.Point
import java.util.*

class Tracks(input: List<String>) {

    private val trackGrid = input.map { it.toCharArray() }.toTypedArray()

    private val tracks = createTracks()

    init {
        linkTracks()
    }

    private fun readGrid(x: Int, y: Int): Char {
        return trackGrid.getOrNull(y)?.getOrNull(x) ?: ' '
    }

    private fun linkTracks() {
        tracks.forEach {
            val top = toTrackType(readGrid(it.position.y - 1, it.position.x))
            val bottom = toTrackType(readGrid(it.position.y + 1, it.position.x))
            val left = toTrackType(readGrid(it.position.y, it.position.x - 1))
            val right = toTrackType(readGrid(it.position.y, it.position.x + 1))

            println("Link ${it.type} in position ${it.position}")

            if (it.type == TrackType.HORIZONTAL) {
                linkHorizontal(it)
            } else if (it.type == TrackType.VERTICAL) {
                linkVertical(it)
            } else if (it.type == TrackType.INTERSECTION) {
                linkHorizontal(it)
                linkVertical(it)
            } else if (it.type == TrackType.CORNER_SLASH) {
                if (top == TrackType.VERTICAL && left == TrackType.HORIZONTAL) {
                    linkTop(it)
                    linkLeft(it)
                } else if (bottom == TrackType.VERTICAL && right == TrackType.HORIZONTAL) {
                    linkBottom(it)
                    linkRight(it)
                }
            } else if (it.type == TrackType.CORNER_BACKSLASH) {
                if (top == TrackType.VERTICAL && right == TrackType.HORIZONTAL) {
                    linkTop(it)
                    linkRight(it)
                } else if (bottom == TrackType.VERTICAL && left == TrackType.HORIZONTAL) {
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