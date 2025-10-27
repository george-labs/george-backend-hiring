import interfaces.WordCountInterface
import service.WordCountService
import java.io.File


fun main(args: Array<String>) {
    val file = File("src/main/resources/stopwords.txt")
    val counter: WordCountInterface = WordCountService(file)

    println("parameter: ${args.toSet()}")

    println("Enter text:")
    val input = readlnOrNull() ?: ""
    val result =counter.count(input)

    println("Number of words: ${result.sumOf { it.count }}")
}
    