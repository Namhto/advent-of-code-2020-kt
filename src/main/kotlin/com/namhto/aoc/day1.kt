package com.namhto.aoc

fun getResult(numbers: IntArray): Int {
    for (i in numbers.indices) {
        for (j in i until numbers.size) {
            for (k in j until numbers.size) {
                if (numbers[i] + numbers[j] + numbers[k] == 2020) {
                    return numbers[i] * numbers[j] * numbers[k]
                }
            }
        }
    }
    return 0
}
