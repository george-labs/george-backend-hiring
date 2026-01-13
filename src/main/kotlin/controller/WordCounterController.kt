package controller

import reader.FileReader
import service.WordCounterService

private const val STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt"

class WordCounterController(
    private val fileReader: FileReader = FileReader(),
    private val wordCounterService: WordCounterService = WordCounterService(
        fileReader.readFileByLine(
            STOPWORDS_FILE_PATH
        )
    ),
) {
    fun start() {
        print("Enter text: ")
        val inputText = readln()
        val wordCount = wordCounterService.countWords(inputText)
        println("Number of words: $wordCount")
    }
}