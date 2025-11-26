import extensions.*


fun main(args: Array<String>) {
    val fileReader = FileReader()
    var words = fileReader.readWords(args.asList().firstOrNull { !it.contains("-index") })
    val index = args.asList().contains("-index")
    val stopWords = fileReader.readStopWords()
    if (words == null) {
        print("Enter text: ")
        words = readln().getDividedWords()
    }

    val filteredWords=words.getFilteredWords(stopWords)

    print("Number of words: ")
    print(filteredWords.countWords())
    print(", unique: ")
    print(filteredWords.countUnique())
    print("; average word length: ")
    print(filteredWords.countAverageWordLength())
    println(" characters")
    if (index) {
        println("Index:")
        filteredWords.sortWords().forEach { println(it) }
    } else {
        println()
    }
}
