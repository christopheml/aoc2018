package com.github.christopheml.day13

import org.junit.jupiter.api.Test

internal class TracksTest {

    @Test
    internal fun name() {
        val (x, y) = Tracks(
            listOf(
                """/->-\        """,
                """|   |  /----\""",
                """| /-+--+-\  |""",
                """| | |  | v  |""",
                """\-+-/  \-+--/""",
                """  \------/     """
            )
        ).simulate()
        println("Crash at $x,$y")
    }
}
