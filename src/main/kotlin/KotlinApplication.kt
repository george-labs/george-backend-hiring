import input.FileBasedReadInputStrategy
import input.ReadInputStrategy
import input.StdinReadInputStrategy
import java.io.InputStream
import java.io.OutputStream

val stopwords: List<String> =
    Thread
        .currentThread()
        .contextClassLoader
        .getResourceAsStream("stopwords.txt")
        ?.bufferedReader()
        ?.readLines()
        ?: error("Internal resource 'stopwords.txt' not found")

fun main(args: Array<String>) {
    executeBusinessLogic(args)
}

fun executeBusinessLogic(
    args: Array<String>,
    readerOutputStream: OutputStream = System.out,
    inputStream: InputStream = System.`in`,
    printerOutputStream: OutputStream = System.out,
) {
    val strategy = chooseReadStrategy(args, readerOutputStream, inputStream)
    val input = strategy.readInput()
    val words = parseInput(input)
    val counter = WordCounter(stopwords)
    val count = counter.countWords(words)
    val uniqueCount = counter.countUniqueWords(words)
    val message = constructMessage(count, uniqueCount)
    printMessage(message, printerOutputStream)
}

fun chooseReadStrategy(
    args: Array<String>,
    outputStream: OutputStream = System.out,
    inputStream: InputStream = System.`in`
): ReadInputStrategy {
    return if (args.isEmpty()) {
        StdinReadInputStrategy(outputStream, inputStream)
    } else {
        FileBasedReadInputStrategy(args[0])
    }
}
