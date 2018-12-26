package com.github.christopheml.day16

class Addr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = output[a] + output[b]
    }

}

class Addi : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] + b
    }

}

class Mulr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] * state[b]
    }

}

class Muli : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] * b
    }

}

class Banr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] and state[b]
    }

}

class Bani : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] and b
    }

}


class Borr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] or state[b]
    }

}

class Bori : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a] or b
    }

}

class Setr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = state[a]
    }

}

class Seti : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = a
    }

}

class Gtir : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (a > state[b]) 1 else 0
    }

}

class Gtri : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (state[a] > b) 1 else 0
    }

}

class Gtrr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (state[a] > state[b]) 1 else 0
    }

}

class Eqir : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (a == state[b]) 1 else 0
    }

}

class Eqri : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (state[a] == b) 1 else 0
    }

}

class Eqrr : Instruction {

    override fun doExecute(state: List<Int>, output: MutableList<Int>, a: Int, b: Int, c: Int) {
        output[c] = if (state[a] == state[b]) 1 else 0
    }

}

fun allInstructions(): List<Instruction> {
    return listOf(
        Addr(),
        Addi(),
        Mulr(),
        Muli(),
        Banr(),
        Bani(),
        Borr(),
        Bori(),
        Setr(),
        Seti(),
        Gtir(),
        Gtri(),
        Gtrr(),
        Eqir(),
        Eqri(),
        Eqrr()
    )
}
