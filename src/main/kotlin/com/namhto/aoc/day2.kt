package com.namhto.aoc

fun getResult(lines: List<String>): Int {
    return lines.map { Regex("(\\d+)-(\\d+)\\s([a-z]):\\s([a-z]+)").find(it)!!.destructured }
        .filter {
            val min = it.component1().toInt()
            val max = it.component2().toInt()
            val char = it.component3()[0]
            val password = it.component4()
            val count = password.count { c -> c == char }
            count in min..max
        }
        .map { it.component4() }
        .count()
}
