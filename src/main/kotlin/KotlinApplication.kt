import extensions.*


fun main(args: Array<String>) {
    val fileReader = FileReader()
    val wordsFromFile = fileReader.readWords(args.asList().firstOrNull { !it.contains("-index") })
    val words = mutableListOf<String>()
    val indexFlag = args.asList().contains("-index")
    val dictionary =
        fileReader.readDictionary(args.asList().firstOrNull { it.contains("-dictionary=", false) }?.split("=")?.last())
    val stopWords = fileReader.readStopWords()
    if (wordsFromFile == null) {
        print("Enter text: ")
        words.addAll(readln().getDividedWords())
    } else {
        words.addAll(wordsFromFile)
    }

    while (words.isNotEmpty()) {
        print(doWordAnalysis(words, stopWords, dictionary, indexFlag))

        words.clear()
        // TODO: Small optimisation to prevent to expect new line after reading from a file, probably 2-5 min solution but currently short of time
//        if (wordsFromFile?.isEmpty() == true) {
        print("Enter text: ")
        words.addAll(readln().getDividedWords())
//        }
    }
}

fun doWordAnalysis(words: List<String>, stopWords: List<String>?, dictionary: List<String>?, index: Boolean): String {
    val filteredWords = words.getFilteredWords(stopWords)
    val unknownWords = filteredWords.getUnknownWords(dictionary)
    val output = StringBuilder()

    output.append("Number of words: ")
    output.append(filteredWords.countWords())
    output.append(", unique: ")
    output.append(filteredWords.countUnique())
    output.append("; average word length: ")
    output.append(filteredWords.countAverageWordLength())
    output.appendLine(" characters")
    if (index) {
        output.appendLine("Index" + if (unknownWords.isNotEmpty()) " (unknown: ${unknownWords.size}):" else ":")
        filteredWords.sortWords().forEach { output.appendLine(it + if (unknownWords.contains(it)) "*" else "") }
    } else {
        output.appendLine()
    }
    return output.toString()
}
