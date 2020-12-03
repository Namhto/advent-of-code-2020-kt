package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day1Test {

    @Test
    fun getResult() {
        val numbers = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day1.txt")!!.toURI()))
            .mapNotNull { it.toInt() }
            .toIntArray()
        val result = getResultDay1(numbers)
        assertThat(result).isEqualTo(69596112)
    }
}
