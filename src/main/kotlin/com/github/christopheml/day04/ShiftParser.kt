package com.github.christopheml.day04

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

internal class ShiftParser(private val log: List<String>) {

    private val messagePattern = Regex("""^\[(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2})] (.*)$""")

    fun parse(): Map<LocalDate, Shift> {
        var builder: ShiftBuilder? = null
        var date: LocalDate? = null

        val shifts = HashMap<LocalDate, Shift>()

        for (entry in log.sorted()) {
            val (year, month, day, hour, minute, message) = messagePattern.matchEntire(entry)!!.destructured

            when (message.substring(message.length - 2)) {
                "ft" -> {
                    if (builder != null && date != null) {
                        shifts[date] = builder.build()
                    }

                    val name = getName(message)

                    builder = ShiftBuilder(name)
                    val entryDate = LocalDateTime.of(year.toInt(), month.toInt(), day.toInt(), hour.toInt(), minute.toInt())
                    date = adjustDate(entryDate)
                }

                "ep" -> {
                    builder!!.sleeps(minute.toInt())
                }

                "up" -> {
                    builder!!.wakesUp(minute.toInt())
                }
            }

        }

        if (builder != null && date != null) {
            shifts[date] = builder.build()
        }

        return shifts
    }

    private fun getName(message: String): Int {
        return message
            .substringAfter("Guard #")
            .substringBefore(" begins")
            .toInt()
    }

    private fun adjustDate(entryDate: LocalDateTime): LocalDate {
        if (entryDate.hour > 12) {
            return entryDate.toLocalDate().plusDays(1)
        }
        return entryDate.toLocalDate()
    }

}
