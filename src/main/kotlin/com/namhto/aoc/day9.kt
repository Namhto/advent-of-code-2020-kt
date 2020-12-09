package com.namhto.aoc

fun getResultDay9(lines: List<String>, step: Int): Long {
    val numbers = lines.map { it.toLong() }
    return getOptionalBadNumber(numbers, step)
}

fun getOptionalBadNumber(numbers: List<Long>, step: Int): Long {
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
    return if (isCurrentNumberBad) currentNumber else getOptionalBadNumber(numbers.subList(1, numbers.size), step)
}
