import interfaces.WordCountInterface
import service.WordCountService
import java.io.File


fun main(args: Array<String>) {
    val file = File("src/main/resources/stopwords.txt")
    val counter: WordCountInterface = WordCountService(file)

    val input = if (args.isNotEmpty()) {
        val inputFile = File("src/main/resources/"+args[0])
        if (inputFile.exists()) inputFile.readText()
        else {
            counter.parseWordFile(inputFile)
            return
        }
    } else {
        println("Enter text:")
        readlnOrNull() ?: ""
    }
    val result = counter.count(input)


    println("Number of words: ${result.sumOf { it.count }}")
}
    