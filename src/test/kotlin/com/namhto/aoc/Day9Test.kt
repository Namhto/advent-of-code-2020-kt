package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day9Test {

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day9.txt")!!.toURI()))
        val result = getResultDay9(lines, 25)
        println(result)
    }

    @Test
    fun getResult_with_example() {
        val lines = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
        )
        val result = getResultDay9(lines, 5)
        assertThat(result).isEqualTo(127)
    }
}
