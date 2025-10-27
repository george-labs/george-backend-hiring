import interfaces.WordCountInterface
import service.WordCountService


fun main() {
    println("Enter text:")
    val input = readlnOrNull() ?: ""

    val counter: WordCountInterface = WordCountService()
    val result =counter.count(input)


    println("Number of words: ${result.sumOf { it.count }}")

}
    