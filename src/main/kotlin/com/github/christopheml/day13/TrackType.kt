package com.github.christopheml.day13

enum class TrackType {
    VERTICAL, HORIZONTAL, CORNER_SLASH, CORNER_BACKSLASH, INTERSECTION, NO_TRACK;
}


fun isValidTrack(c: Char): Boolean {
    return """|v^-<>/\+""".contains(c)
}

fun toTrackType(c: Char): TrackType {
    return when (c) {
        '|', 'v', '^' -> TrackType.VERTICAL
        '-', '<', '>' -> TrackType.HORIZONTAL
        '/' -> TrackType.CORNER_SLASH
        '\\' -> TrackType.CORNER_BACKSLASH
        '+' -> TrackType.INTERSECTION
        else -> TrackType.NO_TRACK
    }
}

