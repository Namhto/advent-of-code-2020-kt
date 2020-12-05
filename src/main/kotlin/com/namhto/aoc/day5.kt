package com.namhto.aoc

fun getResultDay5(lines: List<String>): Int {
    val allIds = (0 * 8 + 0)..(127 * 8 + 7)
    val seatIds = lines.map { it.getSeatId() }
    return allIds.minus(seatIds).find { seatIds.contains(it - 1) && seatIds.contains(it + 1) } ?: 0
}

private fun String.getSeatId(): Int {
    val row = substring(0..6).fold(0..127) { r, c ->
        when (c) {
            'F' -> r.first..r.elementAt(r.count() / 2 - 1)
            'B' -> r.elementAt(r.count() / 2)..r.last
            else -> r
        }
    }.first
    val column = substring(7..9).fold(0..7) { r, c ->
        when (c) {
            'L' -> r.first..r.elementAt(r.count() / 2 - 1)
            'R' -> r.elementAt(r.count() / 2)..r.last
            else -> r
        }
    }.first
    return row * 8 + column
}
