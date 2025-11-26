import extensions.*


fun main(args: Array<String>) {
    val fileReader = FileReader()
    var words = fileReader.readWords(args.asList().firstOrNull { !it.contains("-index") })
    var index = args.asList().contains("-index")
    val stopWords = fileReader.readStopWords()
    if (words == null) {
        print("Enter text: ")
        words = readln().getDividedWords()
    }

    print("Number of words: ")
    print(words.countWords(stopWords))
    print(", unique: ")
    print(words.countUnique(stopWords))
    print("; average word length: ")
    print(words.countAverageWordLength(stopWords))
    println(" characters")
    if (index) {
        println("Index:")
        words.sortWords(stopWords).forEach { println(it) }
    } else {
        println()
    }
}
