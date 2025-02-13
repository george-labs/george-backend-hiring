class MyApplication

fun main() {
    print("Enter text: ")
    val userInput = readlnOrNull() ?: ""

    val wordCount = WordCounter.countWords(userInput)

    println("Number of words: $wordCount")
}