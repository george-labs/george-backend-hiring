package util

import data.WordWrapper
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

class WordFileReader {
    fun getWordsListFromFile(filename: String, isStopWords: Boolean = false): List<WordWrapper> {
        try {
            val inputStream: InputStream = File(filename).inputStream()
            val lineList = mutableListOf<String>()

            inputStream.bufferedReader().forEachLine { lineList.add(it) }
            return lineList.flatMap { it.splitToWords() }
        } catch (e: FileNotFoundException) {
            println("Failed to open ${if (isStopWords) "stop " else ""}words file")
            print("Enter text: ")
            return readln().splitToWords()
        }
    }
}