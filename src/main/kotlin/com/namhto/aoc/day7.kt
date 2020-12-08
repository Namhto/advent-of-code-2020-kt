package com.namhto.aoc

fun getResultDay7(lines: List<String>): Int {
    val rules = lines.map { it.toBagRule() }
    return getMatchingRulesRecursively(rules, "shiny gold").size
}

private fun getMatchingRulesRecursively(rules: List<BagRule>, color: String): Set<String> {
    val matchingColors = rules.filter { it.content.containsKey(color) }.map { it.color }
    return matchingColors.fold(matchingColors.toSet()) { acc, c -> acc.plus(getMatchingRulesRecursively(rules, c)) }
}

private data class BagRule(val color: String, val content: Map<String, Int>)

private fun String.toBagRule(): BagRule {
    val color = substringBefore("bags").trim()
    val contentString = substringAfter("contain").trim(' ', '.')
    return if (contentString == "no other bags") {
        BagRule(color, emptyMap())
    } else {
        val content = contentString.split(",").map {
            val contentColor = it.trim().substringAfter(" ").substringBefore("bag").trim()
            val contentCount = it.trim().substringBefore(" ").trim().toInt()
            contentColor to contentCount
        }.toMap()
        BagRule(color, content)
    }
}
