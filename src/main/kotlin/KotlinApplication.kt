import input.FileBasedReadInputStrategy
import input.ReadInputStrategy
import input.StdinReadInputStrategy

val stopwords : List<String> =
    Thread
        .currentThread()
        .contextClassLoader
        .getResourceAsStream("stopwords.txt")
        ?.bufferedReader()
        ?.readLines()
        ?: error("Internal resource 'stopwords.txt' not found")

fun main(args: Array<String>) {
    val strategy = chooseReadStrategy(args)
    val input = strategy.readInput()
    val words = parseInput(input)
    val counter = WordCounter(stopwords)
    val count = counter.countWords(words)
    val message = constructMessage(count)
    printMessage(message)
}

fun chooseReadStrategy(args: Array<String>): ReadInputStrategy {
    return if (args.isEmpty()) {
        StdinReadInputStrategy()
    } else {
        FileBasedReadInputStrategy(args[0])
    }
}
