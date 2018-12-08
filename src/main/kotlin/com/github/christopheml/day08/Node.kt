package com.github.christopheml.day08

class Node(private val children: List<Node>, private val metadata: List<Int>) {

    fun sumOfAllMetadata(): Int {
        return if (children.isEmpty()) {
            metadata.sum()
        } else {
            metadata.sum() + children.map { it.sumOfAllMetadata() }.sum()
        }
    }

    fun valueOf(): Int {
        return if (children.isEmpty()) {
            metadata.sum()
        } else {
            metadata.mapNotNull { child(it - 1) }.map { it.valueOf() }.sum()
        }
    }

    private fun child(index: Int): Node? {
        return if (index < children.size) children[index] else null
    }

}
