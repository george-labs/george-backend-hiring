fun main(args: Array<String>) {
    val inputReader = if(args.isNotEmpty())
        FileInputReader(args[0])
    else
        StdinInputReader()

    val wordCounter = WordCounter(StopWordsReader(FILENAME))
    val input = inputReader.read()
    val words = wordCounter.count(input)

    println("Number of words: ${words.filteredCount}, unique: ${words.uniqueFilteredCount}")
}