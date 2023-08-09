import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader


object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter text: ")

        val input = BufferedReader(InputStreamReader(System.`in`)).use {
            it.readLine()
        }
        val stopWordFile = File("./stopwords.txt")
        val stopWordsProvider = FileStopWordProvider(stopWordFile)
        val result = WordCounter(
            stopWordsProvider = stopWordsProvider,
        ).countWords(input)
        println("Number of words: $result")
    }
}
