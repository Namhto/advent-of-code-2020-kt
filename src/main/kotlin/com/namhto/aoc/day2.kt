package com.namhto.aoc

fun getResultDay2(lines: List<String>): Int {
    return lines.map { Regex("(\\d+)-(\\d+)\\s([a-z]):\\s([a-z]+)").find(it)!!.destructured }
        .filter {
            val first = it.component1().toInt() - 1
            val second = it.component2().toInt() - 1
            val char = it.component3()[0]
            val password = it.component4()
            (password[first] == char).xor(password[second] == char)
        }
        .map { it.component4() }
        .count()
}
