package com.github.christopheml.day16

interface Instruction {

    fun execute(state: List<Int>, a: Int, b: Int, c: Int): List<Int> {
        val output = ArrayList<Int>(state)
        doExecute(state, output, a, b, c)
        return output
    }

    fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int)

}
