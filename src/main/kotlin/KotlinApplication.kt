import extensions.*


fun main(args: Array<String>) {
    val fileReader = FileReader()
    var words = fileReader.readWords(args.asList().firstOrNull { !it.contains("-index") })
    val index = args.asList().contains("-index")
    val dictionary = fileReader.readDictionary(args.asList().first { it.contains("-dictionary=", false) }.split("=").last())
    val stopWords = fileReader.readStopWords()
    if (words == null) {
        print("Enter text: ")
        words = readln().getDividedWords()
    }

    val filteredWords = words.getFilteredWords(stopWords)
    val unknownWords = filteredWords.getUnknownWords(dictionary)

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
