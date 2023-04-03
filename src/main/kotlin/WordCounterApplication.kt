import java.nio.file.Files
import java.nio.file.Path

fun main(args: Array<String>) {
    val stopWords = if (args.isEmpty()) emptySet() else Files.readAllLines(Path.of(args.first())).toSet()
    val counter = WordCounter(stopWords)

    print("Enter text: ")

    val inputLine = readln()
    val count = counter.countWords(inputLine)

    println("Number of words: $count")

}
