
val stopwords : List<String> =
    Thread
        .currentThread()
        .contextClassLoader
        .getResourceAsStream("stopwords.txt")
        ?.bufferedReader()
        ?.readLines()
        ?: error("Internal resource 'stopwords.txt' not found")

fun main() {
    val input = readInput()
    val words = parseInput(input)
    val counter = WordCounter(stopwords)
    val count = counter.countWords(words)
    val message = constructMessage(count)
    printMessage(message)
}

