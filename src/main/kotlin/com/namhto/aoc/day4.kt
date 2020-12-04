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
    this.keys.containsAll(listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"))
