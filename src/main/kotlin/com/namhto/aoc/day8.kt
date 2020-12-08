package com.namhto.aoc

fun getResultOfFixedProgram(lines: List<String>): Int {
    val instructions = lines.map { it.toInstruction() }
    for ((index, instruction) in instructions.withIndex()) {
        if (instruction.value == "nop" || instruction.value == "jmp") {
            val newInstructions = instructions.mapIndexed { oldIndex, oldInstruction ->
                if (oldIndex == index) {
                    val newValue = if (oldInstruction.value == "jmp") "nop" else "jmp"
                    Instruction(newValue, oldInstruction.offset, false)
                } else {
                    Instruction(oldInstruction.value, oldInstruction.offset, false)
                }
            }
            try {
                val result = runInstructions(newInstructions)
                println("Corrupted instruction is '${instruction.value} ${instruction.offset}' (instruction number ${index + 1})")
                return result
            } catch (e: IllegalStateException) {
            }
        }
    }
    throw IllegalStateException("No nop / jmp instruction swap resulted in non infinite loop")
}

fun runInstructions(instructions: List<Instruction>): Int {
    var accumulator = 0
    var nextInstructionIndex = 0
    while (true) {
        val instruction = instructions[nextInstructionIndex]
        if (instruction.alreadyExecuted) {
            throw IllegalStateException()
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
        if (nextInstructionIndex >= instructions.size) {
            break
        }
    }
    return accumulator
}

data class Instruction(val value: String, val offset: Int, var alreadyExecuted: Boolean)

private fun String.toInstruction() = Instruction(
    substringBefore(" "),
    substringAfter(" ").toInt(),
    false
)
