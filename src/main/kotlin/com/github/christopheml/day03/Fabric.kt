package com.github.christopheml.day03

import com.github.christopheml.common.PuzzleInput

internal class Fabric {

    private val claimed: MutableMap<Pair<Int, Int>, MutableSet<String>> = HashMap()

    fun claim(claim: Claim) {
        claim.points().forEach {
            claimed.merge(it, mutableSetOf(claim.id)) { left, right -> left.addAll(right); left }
        }
    }

    fun claimedTwice(): Int {
        return claimed.count { entry -> entry.value.size > 1 }
    }

}

fun main(args: Array<String>) {
    val splitter = Regex(" @ |: ")
    val claims = PuzzleInput("day03.txt").asList()
        .map { s -> splitter.split(s) }
        .map { s -> toClaim(s[0], s[1], s[2]) }
    val fabric = Fabric()
    claims.forEach { fabric.claim(it) }
    println("Solution to first part is " + fabric.claimedTwice())
}

internal fun toClaim(id: String, point: String, size: String): Claim {
    val coordinates = point.split(",")
    val dimensions = size.split("x")
    return Claim(
        id,
        Pair(coordinates[0].toInt(), coordinates[1].toInt()),
        Pair(dimensions[0].toInt(), dimensions[1].toInt())
    )
}
