import extensions.*


fun main(args: Array<String>) {
    val fileReader = FileReader()
    var words = fileReader.readWords(args.asList().firstOrNull { !it.contains("-index") })
    val index = args.asList().contains("-index")
    val dictionaryFlag = args.asList().filter { it.contains("-dictionary")}
    val stopWords = fileReader.readStopWords()
    val dictionary = fileReader.readDictionary()
    if (words == null) {
        print("Enter text: ")
        words = readln().getDividedWords()
    }

    val filteredWords = words.getFilteredWords(stopWords)
    val unknownWords = filteredWords.filter { dictionary?.contains(it) == false }

    print("Number of words: ")
    print(filteredWords.countWords())
    print(", unique: ")
    print(filteredWords.countUnique())
    print("; average word length: ")
    print(filteredWords.countAverageWordLength())
    println(" characters")
    if (index) {
        println("Index" + if (unknownWords.isNotEmpty()) " (unknown: ${unknownWords.size}):" else ":")
        filteredWords.sortWords().forEach { println(it + if (unknownWords.contains(it)) "*" else "") }
    } else {
        println()
    }
}
