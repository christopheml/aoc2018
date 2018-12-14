package com.github.christopheml.day13

import org.junit.jupiter.api.Test

internal class TracksTest {

    @Test
    internal fun first_crash() {
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

    @Test
    internal fun highlander() {
        val (x, y) = Tracks(
            listOf(
                """/>-<\  """,
                """|   |  """,
                """| /<+-\""",
                """| | | v""",
                """\>+</ |""",
                """  |   ^""",
                """  \<->/"""
            )
        ).highlander()
        println("Survivor at $x,$y")
    }

}
