fun main(args: Array<String>) {
    val inputReader = if(args.isNotEmpty())
        FileInputReader(args[0])
    else
        StdinInputReader()

    println()
    val wordCounter = WordCounter(StopWordsReader())
    val input = inputReader.read()
    val count = wordCounter.count(input)

    println("Number of words: $count")
}