import impl.StopWordContext

class MyApplication

fun main() {
    print("Enter text: ")
    val userInput = readlnOrNull() ?: ""

    val stopWordContext = StopWordContext()
    val wordCount = WordCounter(stopWordContext).countWords(userInput)

    println("Number of words: $wordCount")
}