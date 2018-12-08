package com.github.christopheml.day08

import com.github.christopheml.common.PuzzleInput
import java.util.*

class TreeBuilder(input: Collection<Int>) {

    private val licenceFile = ArrayDeque<Int>(input)

    fun build(): Node {
        return createNode()
    }

    private fun createNode(): Node {
        val childrenCount = licenceFile.pollFirst()!!
        val metadataCount = licenceFile.pollFirst()!!

        val children = ArrayList<Node>(childrenCount)
        for (i in 0 until childrenCount) {
            children.add(createNode())
        }

        val metadata = ArrayList<Int>(metadataCount)
        for (i in 0 until metadataCount) {
            metadata.add(licenceFile.pollFirst()!!)
        }

        return Node(children, metadata)
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput(8).asString().splitToSequence(" ").map { it.toInt() }.toList()
    val tree = TreeBuilder(input).build()
    println("Solution to the first part is: " + tree.sumOfAllMetadata())
    println("Solution to the second part is: " + tree.valueOf())
}
