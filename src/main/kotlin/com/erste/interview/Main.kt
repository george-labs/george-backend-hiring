package com.erste.interview

import com.erste.interview.io.CliInputTextProvider
import com.erste.interview.io.FileInputTextProvider
import com.erste.interview.io.InputTextProvider
import com.erste.interview.logic.WordCounter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.Reader
import java.io.Writer
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    runWordCounter(args, InputStreamReader(System.`in`), OutputStreamWriter(System.out))
}

fun runWordCounter(args: Array<String>, input: Reader, output: Writer) {
    when {
        args.isEmpty() -> {
            // We go with command-line I0
            output.write("Enter text: ")
            output.flush()

            val inputTextProvider = CliInputTextProvider(input)

            runWordCounter(inputTextProvider, output)
        }
        args.size == 1 -> {
            // go with file input
            val filepath = args[0]

            val fileInputTextProvider = FileInputTextProvider(filepath)

            runWordCounter(fileInputTextProvider, output)
        }
        else -> {
            println("""
                Check usage:
                TODO
            """.trimIndent())
            exitProcess(1)
        }
    }
}

private fun runWordCounter(inputTextProvider: InputTextProvider, output: Writer) {
    // 1. get input
    val input = inputTextProvider.readInput()

    // 2. call business logic
    val wordCounter = WordCounter()
    val stopWords = readStopwords()
    val wordCount = wordCounter.countWords(input, stopWords)

    // 4. Output to user
    output.write("\nNumber of words: $wordCount")
    output.flush()
}

private fun readStopwords(): Set<String> {
    val inputStream = object {}.javaClass.getResourceAsStream("/stopwords.txt") ?: throw RuntimeException("Resource stopwords.txt not available")
    return inputStream
        .bufferedReader()
        .readLines()
        .filter { it.isNotBlank() }
        .toSet()
}