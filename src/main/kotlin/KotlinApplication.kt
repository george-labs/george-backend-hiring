import java.io.File

fun main(args: Array<String>) {
    val stopWords = File("stopwords.txt").readLines().toSet()

    print("Enter text: ")
    val inputText = readln()

    val wordCount = WordCounter(
        stopWords = stopWords
    ).countWordsInText(inputText)

    println("Number of words: $wordCount")
}
