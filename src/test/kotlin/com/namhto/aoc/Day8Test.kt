package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day8Test {

    @Test
    fun getResultOfFixedProgram() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day8.txt")!!.toURI()))
        val result = getResultOfFixedProgram(lines)
        println(result)
    }

    @Test
    fun getResultOfFixedProgram_with_example() {
        val lines = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )
        val result = getResultOfFixedProgram(lines)
        assertThat(result).isEqualTo(8)
    }
}
