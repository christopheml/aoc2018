package com.github.christopheml.day13

import org.junit.jupiter.api.Test

internal class TracksTest {

    @Test
    internal fun name() {
        Tracks(
            listOf(
                """/->-\        """,
                """|   |  /----\""",
                """| /-+--+-\  |""",
                """| | |  | v  |""",
                """\-+-/  \-+--/""",
                """  \------/     """
            )
        )
    }
}