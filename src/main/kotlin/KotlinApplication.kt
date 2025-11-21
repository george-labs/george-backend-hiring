import java.util.*

fun main() {
    // system prompt
    print("Enter text: ")
    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine()

    //   call service
    val service = WordService()
    val wordsCount = service.countWords(line)

    //   print result
    println("Number of words: $wordsCount")
}