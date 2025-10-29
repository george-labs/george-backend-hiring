package at.erste.digital.wordcounter.input

import java.nio.file.Files
import java.nio.file.Paths

class StopWordsReader(private val fileName: String = "src/main/kotlin/stopwords.txt") {
    fun loadStopWords(): Result<List<String>> =
        runCatching { Files.readAllLines(Paths.get(fileName)) }
}