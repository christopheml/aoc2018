package com.github.christopheml.day12

enum class PotContent {
    PLANT {
        override fun toChar(): Char = '#'
    },
    EMPTY {
        override fun toChar(): Char = '.'
    };

    abstract fun toChar(): Char

    fun times(n: Int): List<PotContent> {
        return List(n) { this }
    }

}
