import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class WordCounterInput(
    private val wordCounter: WordCounter
) {

    fun process(inputFile: String? = null): WordCounterResult {
        val inputString = if (inputFile == null) {
            println("Enter text: ")
            BufferedReader(InputStreamReader(System.`in`)).use {
                it.readLine()
            }
        } else {
            File(inputFile).readText().replace("\n", " ")
        }
        return wordCounter.countWords(inputString)
    }
}
