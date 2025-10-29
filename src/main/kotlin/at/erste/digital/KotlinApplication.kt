package at.erste.digital

import at.erste.digital.wordcounter.WordCounter

fun main() {
    println("Enter text: ")
    val input = runCatching {
        readln()
    }.onFailure {
        println("Error: ${it.message}")
        return
    }.getOrThrow()
    val numberOfWords = WordCounter.countWords(input)
    println("Number of words: $numberOfWords")
}