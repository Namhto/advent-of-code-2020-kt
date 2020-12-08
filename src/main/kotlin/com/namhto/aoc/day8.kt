package com.namhto.aoc

fun getResultDay8(lines: List<String>): Int {
    val instructions = lines.map { it.toInstruction() }
    var accumulator = 0
    var nextInstructionIndex = 0
    while (true) {
        val instruction = instructions[nextInstructionIndex]
        if (instruction.alreadyExecuted) {
            break
        }
        when (instruction.value) {
            "nop" -> nextInstructionIndex++
            "acc" -> {
                accumulator += instruction.offset
                nextInstructionIndex++
            }
            "jmp" -> nextInstructionIndex += instruction.offset
        }
        instruction.alreadyExecuted = true
    }
    return accumulator
}

private data class Instruction(val value: String, val offset: Int, var alreadyExecuted: Boolean)

private fun String.toInstruction() = Instruction(
    substringBefore(" "),
    substringAfter(" ").toInt(),
    false
)
