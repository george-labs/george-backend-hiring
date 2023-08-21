fun readUserInput(): String {
    print("Enter text: ")
    return readln()
}


// resources/mytext.txt resources/stopwords.txt
fun main(args: Array<String>) {
    val app = App(args.toList())
    val stopWords = app.readStopWordsFile()
    val words = app.readTextFile()
    val content = if (words.isEmpty()) readUserInput() else words.joinToString(separator=" ")
    val wordCount = WordCounter.wordCount(content, stopWords)

    println("Number of words: $wordCount")
}