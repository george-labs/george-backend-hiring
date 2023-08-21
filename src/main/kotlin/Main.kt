import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun readUserInput(): String {
    print("Enter text: ")
    return readln()
}


// resources/mytext.txt resources/stopwords.txt
fun main(args: Array<String>) {
    try {
        val app = App(args.toList())
        val stopWords = app.readStopWordsFile()
        val words = app.readTextFile()
        val content = if (words.isEmpty()) readUserInput() else words.joinToString(separator=" ")
        val (wordCount, uniqueWordCount) = WordCounter.wordCount(content, stopWords)
        println("Number of words: $wordCount, unique: $uniqueWordCount")
    } catch(e: Exception) {
        when(e) {
            is InvalidNumberOfArgsException,
            is FileNotFoundException-> {
                println(e.message)
                exitProcess(1)
            }
            else -> throw e
        }
    }
}