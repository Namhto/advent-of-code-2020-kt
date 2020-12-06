package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day6Test {

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day6.txt")!!.toURI()))
        val result = getResultDay6(lines)
        println(result)
    }

    @Test
    fun getResult_with_example() {
        val lines = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
        )
        val result = getResultDay6(lines)
        assertThat(result).isEqualTo(6)
    }
}
