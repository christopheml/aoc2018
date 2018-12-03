package com.github.christopheml.day03

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
