package com.namhto.aoc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Path

internal class Day4Test {

    @Test
    fun getResult() {
        val lines = Files.readAllLines(Path.of(this.javaClass.classLoader.getResource("input_day4.txt")!!.toURI()))
        val result = getResultDay4(lines)
        println(result)
    }

    @Test
    fun getResult_with_small_example() {
        val lines = listOf(
            "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
            "byr:1937 iyr:2017 cid:147 hgt:183cm",
            "",
            "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
            "hcl:#cfa07d byr:1929",
            "",
            "hcl:#ae17e1 iyr:2013",
            "eyr:2024",
            "ecl:brn pid:760753108 byr:1931",
            "hgt:179cm",
            ""
        )
        val result = getResultDay4(lines)
        assertThat(result).isEqualTo(2)
    }
}
