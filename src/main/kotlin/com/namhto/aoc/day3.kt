package com.namhto.aoc

fun getResultDay3(lines: List<String>, slopes: List<Pair<Int, Int>>) = slopes.fold(1L) { acc, (right, down) ->
    acc * getEncounteredTrees(lines, right, down)
}

private fun getEncounteredTrees(lines: List<String>, slopeRight: Int, slopeDown: Int): Long {
    val patternWidth = lines[0].length
    var column = slopeRight
    var encounteredTrees = 0L
    for (i in slopeDown until lines.size step slopeDown) {
        if (column >= patternWidth) {
            column -= patternWidth
        }
        if (lines[i][column] == '#') {
            encounteredTrees++
        }
        column += slopeRight
    }
    return encounteredTrees
}
