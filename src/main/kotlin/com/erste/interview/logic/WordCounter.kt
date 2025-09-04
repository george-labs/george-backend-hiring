package com.erste.interview.logic

class WordCounter {

    private val regex = Regex("[a-zA-Z-]+")

    fun count(text: String, stopWords: Set<String>): CountResult {
        val filteredWords = filterWords(text, stopWords)
        return CountResult(
            wordCount = filteredWords.size,
            uniqueCount = filteredWords.toSet().size,
        )
    }

    private fun filterWords(text: String, stopWords: Set<String>): List<String> {
        return text.split(Regex("\\s+"))
            .filter { regex.matches(it) }
            .filterNot { stopWords.contains(it) }
            .filterNot { it.startsWith("-") || it.endsWith("-")}
    }

}