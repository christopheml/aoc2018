package com.github.christopheml.day03

import com.github.christopheml.common.Point
import com.github.christopheml.common.PuzzleInput

internal class Fabric {

    private val claimed: MutableMap<Point, MutableSet<String>> = HashMap()

    fun claim(claim: Claim) {
        claim.points().forEach {
            claimed.merge(it, mutableSetOf(claim.id)) { left, right -> left.addAll(right); left }
        }
    }

    fun claimedTwice(): Int {
        return claimed.count { entry -> entry.value.size > 1 }
    }

    fun notOverlapping(): String {
        val all = claimed.values.flatten().toSet()
        val overlapping = claimed.values.filter { ids -> ids.size > 1 }.flatten().toSet()
        return all.minus(overlapping).first()
    }

}

fun main(args: Array<String>) {
    val splitter = Regex(" @ |: ")
    val claims = PuzzleInput(3).asList()
        .map { s -> splitter.split(s) }
        .map { s -> toClaim(s[0], s[1], s[2]) }
    val fabric = Fabric()
    claims.forEach { fabric.claim(it) }
    println("Solution to first part is " + fabric.claimedTwice())
    println("Solution to second part is " + fabric.notOverlapping())
}

internal fun toClaim(id: String, point: String, size: String): Claim {
    val coordinates = point.split(",")
    val dimensions = size.split("x")
    return Claim(
        id,
        Point(coordinates[0].toInt(), coordinates[1].toInt()),
        dimensions[0].toInt(),
        dimensions[1].toInt()
    )
}
