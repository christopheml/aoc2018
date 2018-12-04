package com.github.christopheml.day04

import java.util.*

internal class ShiftParser(private val log: List<String>) {

    private val messagePattern = Regex("""^\[.*:(\d{2})] (.*)$""")

    fun parse(): List<Shift> {
        var builder: ShiftBuilder? = null
        val shifts = ArrayList<Shift>()

        for (entry in log.sorted()) {
            val (minute, message) = messagePattern.matchEntire(entry)!!.destructured

            when (message.substring(message.length - 2)) {
                "ft" -> {
                    if (builder != null) {
                        shifts.add(builder.build())
                    }

                    builder = ShiftBuilder(getName(message))
                }

                "ep" -> {
                    builder!!.sleeps(minute.toInt())
                }

                "up" -> {
                    builder!!.wakesUp(minute.toInt())
                }
            }

        }

        if (builder != null) {
            shifts.add(builder.build())
        }

        return shifts.toList()
    }

    private fun getName(message: String): Int {
        return message
            .substringAfter("Guard #")
            .substringBefore(" begins")
            .toInt()
    }

}
