package com.github.christopheml.day03

import com.github.christopheml.common.PuzzleInput

internal class Fabric {

    private val claimed: MutableMap<Pair<Int, Int>, Int> = HashMap()

    fun claim(claim: Claim) {
        claim.points().forEach {
            point -> claimed.merge(point, 1) { _, value -> value + 1}
        }
    }

    fun claimedTwice(): Int {
        return claimed.count { entry -> entry.value > 1 }
    }

}

fun main(args: Array<String>) {
    val splitter = Regex(" @ |: ")
    val claims = PuzzleInput("day03.txt").asList()
        .map { s -> splitter.split(s) }
        .map { s -> toClaim(s[1], s[2]) }
    val fabric = Fabric()
    claims.forEach { fabric.claim(it) }
    println("Solution to first part is " + fabric.claimedTwice())
}

internal fun toClaim(point: String, size: String): Claim {
    val coordinates = point.split(",")
    val dimensions = size.split("x")
    return Claim(
        Pair(coordinates[0].toInt(), coordinates[1].toInt()),
        Pair(dimensions[0].toInt(), dimensions[1].toInt())
    )
}
