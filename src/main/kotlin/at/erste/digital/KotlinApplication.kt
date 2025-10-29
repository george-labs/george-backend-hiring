package at.erste.digital

import at.erste.digital.wordcounter.WordCounter
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val stopWords = runCatching { Files.readAllLines(Paths.get("stopwords.txt")) }.onFailure {
        println("IO error $it")
        return
    }.getOrThrow()
    val wordCounter = WordCounter(stopWords)

    println("Enter text: ")
    val input = runCatching {
        readln()
    }.onFailure {
        println("Error: ${it.message}")
        return
    }.getOrThrow()
    val numberOfWords = wordCounter.countWords(input)
    println("Number of words: $numberOfWords")
}