package com.namhto.aoc

fun getResultDay7(lines: List<String>): Int {
    val rules = lines.map { it.toBagRule() }
    return getNumberOfBagsRecursively(rules, "shiny gold")
}

private fun getNumberOfBagsRecursively(rules: List<BagRule>, color: String): Int {
    val matchingRule = rules.find { it.color == color }!!
    return matchingRule.content.values.sum() + matchingRule.content.map { (color, count) ->
        count * getNumberOfBagsRecursively(
            rules,
            color
        )
    }.sum()
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
