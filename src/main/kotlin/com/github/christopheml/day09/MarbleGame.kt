package com.github.christopheml.day09

class MarbleGame(playerCount: Int) {

    private val marbles = Marbles()

    private val scores = Array(playerCount) { 0 }

    fun playUntil(lastMarbleScore: Int): Array<Int> {
        for (turn in 0 until lastMarbleScore) {
            scores[turn % scores.size] += marbles.play()
        }
        return scores
    }

}

fun main(args: Array<String>) {
    val game = MarbleGame(486)
    println("Solution to the first part is " + game.playUntil(70833 ).max()!!)

    val game2 = MarbleGame(486)
    println("Solution to the first part is " + game2.playUntil(7083300 ).max()!!)

}
