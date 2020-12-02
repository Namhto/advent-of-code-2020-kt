package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day2Test {

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day2.txt")!!.toURI()))
        val result = getResult(lines)
        println(result)
    }

    @Test
    fun getResult_with_small_example() {
        val lines = listOf(
            "1-3 a: abcde",
            "1-3 b: cdefg",
            "2-9 c: ccccccccc"
        )
        val result = getResult(lines)
        assertThat(result).isEqualTo(1)
    }
}
