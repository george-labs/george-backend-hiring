package at.erste.digital.wordcounter

import at.erste.digital.wordcounter.input.InputReaderFactory
import at.erste.digital.wordcounter.input.StopWordsReader
import at.erste.digital.wordcounter.service.WordCounter

fun main(args: Array<String>) {
    val stopWordsReader = StopWordsReader()
    val stopWords = stopWordsReader.loadStopWords().onFailure {
        println("IO error $it")
    }.getOrThrow()
    val wordCounter = WordCounter(stopWords)

    val input = InputReaderFactory.getInputReaderBasedOnArguments(args).readWords().onFailure {
        println("Error: ${it.message}")
        return
    }.getOrThrow()
    val numberOfWords = wordCounter.countWords(input)
    val numberOfUniqueWords = wordCounter.countUniqueWords(input)
    println("Number of words: $numberOfWords, unique: $numberOfUniqueWords")
}