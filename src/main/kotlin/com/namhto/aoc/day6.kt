package com.namhto.aoc

fun getResultDay6(lines: List<String>): Int {
    val groups = mutableListOf<List<String>>()
    var currentGroup = listOf<String>()
    for (line in lines.plus("")) {
        currentGroup = if (line == "") {
            groups.add(currentGroup)
            listOf()
        } else {
            currentGroup.plus(line)
        }
    }
    return getResultRecursively(groups)
}

fun getResultRecursively(groups: List<List<String>>): Int {
    if (groups.isEmpty()) {
        return 0
    }
    val group = groups[0]
    var result = 0
    val yesQuestions = mutableMapOf<Char, Int>()
    group.forEach { responses ->
        responses.forEach { response ->
            yesQuestions.compute(response) { _, counter ->
                counter?.plus(
                    1
                ) ?: 1
            }
        }
    }
    result = yesQuestions.filter { (_, value) -> value == group.size }.count()
    return result + getResultRecursively(groups.subList(1, groups.size))
}
