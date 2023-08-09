import java.io.BufferedReader
import java.io.InputStreamReader


object KotlinApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter text: ")

        val input = BufferedReader(InputStreamReader(System.`in`)).use {
            it.readLine()
        }
        val result = WordCounter().countWords(input)
        println("Number of words: $result")
    }
}
