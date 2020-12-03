package com.namhto.aoc

fun getResultDay3(lines: List<String>): Int {
    val width = lines[0].length
    var column = 3
    var encounteredTrees = 0
    for (i in 1 until lines.size) {
        if (column >= width) {
            column -= width
        }
        if (lines[i][column] == '#') {
            encounteredTrees++
        }
        column += 3
    }
    return encounteredTrees
}
