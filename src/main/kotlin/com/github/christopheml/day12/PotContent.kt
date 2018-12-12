package com.github.christopheml.day12

enum class PotContent {
    PLANT {
        override fun toChar(): Char = '#'
    },
    EMPTY {
        override fun toChar(): Char = '.'
    };

    abstract fun toChar(): Char
}
