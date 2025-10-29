package at.erste.digital.wordcounter

import at.erste.digital.wordcounter.input.InputReaderFactory
import at.erste.digital.wordcounter.input.StopWordsReader
import at.erste.digital.wordcounter.service.InputStatisticsService

fun main(args: Array<String>) {
    val stopWordsReader = StopWordsReader()
    val stopWords = stopWordsReader.loadStopWords().onFailure {
        println("IO error $it")
    }.getOrThrow()
    val inputStatisticsService = InputStatisticsService(stopWords)

    val input = InputReaderFactory.getInputReaderBasedOnArguments(args).readWords().onFailure {
        println("Error: ${it.message}")
        return
    }.getOrThrow()
    val inputStatistics = inputStatisticsService.getInputStatistics(input)
    println("Number of words: ${inputStatistics.wordCount}, unique: ${inputStatistics.uniqueWordCount}. Average length ${inputStatistics.averageLength}")
}