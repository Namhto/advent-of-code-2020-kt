package com.namhto.aoc

fun getResultDay6(lines: List<String>): Int {
    val currentGroupYesQuestions = mutableSetOf<Char>()
    var result = 0
    for (line in lines.plus("")) {
        if (line != "") {
            currentGroupYesQuestions.addAll(line.toCharArray().toTypedArray())
        } else {
            result += currentGroupYesQuestions.size
            currentGroupYesQuestions.clear()
        }
    }
    return result
}
