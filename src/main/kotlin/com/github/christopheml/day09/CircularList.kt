package com.github.christopheml.day09

internal class CircularList<T>(initialValue: T) {

    private var current = Node(null, null, initialValue)

    private val originalNode = current

    init {
        current.next = current
        current.previous = current
    }

    fun goClockwise(offset: Int) {
        for (i in 0 until offset) {
            current = current.next!!
        }
    }

    fun goCounterclockwise(offset: Int) {
        for (i in 0 until offset) {
            current = current.previous!!
        }
    }

    fun currentValue(): T {
        return current.value
    }

    fun insertAfter(value: T) {
        val node = Node(null, null, value)
        node.insertBefore(current.next!!)
        node.insertAfter(current)
        current = node
    }

    fun remove(): T {
        val value = current.value
        val previous = current.previous!!
        val next = current.next!!
        previous.insertBefore(next)
        current = next
        return value
    }

    fun toList(): List<T> {
        val list = ArrayList<T>()
        var cursor = originalNode
        do {
            list.add(cursor.value)
            cursor = cursor.next!!
        } while (cursor != originalNode)
        return list
    }

    private class Node<T>(var previous: Node<T>?, var next: Node<T>?, val value: T) {

        fun insertAfter(other: Node<T>) {
            previous = other
            other.next = this
        }

        fun insertBefore(other: Node<T>) {
            next = other
            other.previous = this
        }

    }

}
