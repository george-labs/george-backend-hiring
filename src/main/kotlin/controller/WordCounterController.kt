package controller

import model.ArgumentsStore
import reader.FileReader
import service.WordCounterService

private const val STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt"

class WordCounterController(
    private val arguments: ArgumentsStore = ArgumentsStore(),
    private val fileReader: FileReader = FileReader(),
    private val wordCounterService: WordCounterService = WordCounterService(
        fileReader.readFileByLine(
            STOPWORDS_FILE_PATH
        )
    ),
) {
    fun start() {
       val wordCount = startWithUserInput()
        println("Number of words: $wordCount")
    }

    fun startWithUserInput(): Int {
        print("Enter text: ")
        val inputText = readln()
        return wordCounterService.countWords(inputText)
    }
}