package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day5Test {

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day5.txt")!!.toURI()))
        val result = getResultDay5(lines)
        println(result)
    }

    @Test
    fun getResult_with_example() {
        val lines = listOf(
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
        )
        val result = getResultDay5(lines)
        assertThat(result).isEqualTo(820)
    }
}
