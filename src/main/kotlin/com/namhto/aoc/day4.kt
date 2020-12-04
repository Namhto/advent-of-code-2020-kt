package com.namhto.aoc

fun getResultDay4(lines: List<String>): Int {
    val currentPassportData = mutableMapOf<String, String>()
    var validPassports = 0
    for (line in lines.plus("")) {
        if (line != "") {
            line.split(" ")
                .map { it.substringBefore(":") to it.substringAfter(":") }
                .forEach { (key, value) -> currentPassportData[key] = value }
        } else {
            validPassports += if (currentPassportData.isValid()) 1 else 0
            currentPassportData.clear()
        }
    }
    return validPassports
}

private fun Map<String, String>.isValid() =
    keys.containsAll(fields.keys) && all { (key, value) -> fields[key]?.invoke(value) ?: true }

private val fields: Map<String, (v: String) -> Boolean> = mapOf(
    "byr" to { it.length == 4 && it.toInt() >= 1920 && it.toInt() <= 2002 },
    "iyr" to { it.length == 4 && it.toInt() >= 2010 && it.toInt() <= 2020 },
    "eyr" to { it.length == 4 && it.toInt() >= 2020 && it.toInt() <= 2030 },
    "hgt" to {
        if (it.contains("cm")) {
            val value = it.substringBefore("cm")
            value.length == 3 && value.toInt() >= 150 && value.toInt() <= 193
        } else if (it.contains("in")) {
            val value = it.substringBefore("in")
            value.length == 2 && value.toInt() >= 59 && value.toInt() <= 76
        } else {
            false
        }
    },
    "hcl" to { Regex("#[0-9a-f]{6}").matches(it) },
    "ecl" to { listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").any { item -> item == it } },
    "pid" to { Regex("[0-9]{9}").matches(it) },
)
