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

class Node(private val children: List<Node>, private val metadata: List<Int>) {

    private fun <T> visit(valueFunction: (Node) -> T, mergeFunction: (List<T>) -> T): T {
        val ownValue = valueFunction.invoke(this)
        return if (children.isEmpty()) {
            ownValue
        } else {
            mergeFunction.invoke(children.map { it.visit(valueFunction, mergeFunction) } + ownValue)
        }
    }

    fun sumOfAllMetadata(): Int {
        return visit({ it.metadata.sum() }, { it.sum() })
    }

}

fun main(args: Array<String>) {
    val input = PuzzleInput(8).asString().splitToSequence(" ").map { it.toInt() }.toList()
    val tree = TreeBuilder(input).build()
    println("Solution to the first part is: " + tree.sumOfAllMetadata())
}
