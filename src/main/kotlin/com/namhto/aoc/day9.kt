package com.namhto.aoc

fun getResultDay9(lines: List<String>, step: Int): Long {
    val numbers = lines.map { it.toLong() }
    val badNumber = getBadNumber(numbers, step)
    println("bad number: $badNumber")
    val numbersBeforeBadNumber = numbers.takeWhile { it != badNumber }
    for ((firstIndex, _) in numbersBeforeBadNumber.withIndex()) {
        var sumList = emptyList<Long>()
        var i = 1
        while (sumList.isEmpty() && firstIndex + i < numbersBeforeBadNumber.size) {
            val testedList = numbersBeforeBadNumber.subList(firstIndex, firstIndex + i + 1)
            if (testedList.sum() == badNumber) {
                sumList = testedList
            } else {
                i++
            }
        }
        if (sumList.isNotEmpty()) {
            println(
                "first: ${sumList.minOrNull()} (index ${numbersBeforeBadNumber.indexOf(sumList.minOrNull())}) - last: ${sumList.maxOrNull()} (index ${
                    numbersBeforeBadNumber.indexOf(
                        sumList.maxOrNull()
                    )
                })"
            )
            return sumList.minOrNull()!! + sumList.maxOrNull()!!
        }
    }
    return -1
}

fun getBadNumber(numbers: List<Long>, step: Int): Long {
    if (numbers.size == step) {
        return -1
    }
    val currentNumber = numbers[step]
    val previousNumbers = numbers.subList(0, step)
    val isCurrentNumberBad = previousNumbers.none { currentPrevious ->
        previousNumbers.minus(currentPrevious)
            .none { anyPrevious -> anyPrevious + currentPrevious == currentNumber }
            .not()
    }
    return if (isCurrentNumberBad) currentNumber else getBadNumber(numbers.subList(1, numbers.size), step)
}
