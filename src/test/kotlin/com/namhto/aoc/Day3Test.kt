package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day3Test {

    private val slopes = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day3.txt")!!.toURI()))
        val result = getResultDay3(lines, slopes)
        println(result)
    }

    @Test
    fun getResult_with_small_example() {
        val lines = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )
        val result = getResultDay3(lines, slopes)
        assertThat(result).isEqualTo(336)
    }
}
