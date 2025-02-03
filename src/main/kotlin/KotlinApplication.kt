import util.WordCounter
import util.WordFileReader
import util.splitToWords

const val STOP_WORD_FILE = "stopwords.txt"

fun main(vararg args: String) {
    val counter = WordCounter()
    val stopWords = WordFileReader().getWordsListFromFile(STOP_WORD_FILE, isStopWords = true)

    val words = if (args.isNotEmpty() && args[0] != "-index") {
        WordFileReader().getWordsListFromFile(args[0], isStopWords = false)
    } else {
        print("Enter text: ")
        readln().splitToWords()
    }

    println(
        "Number of words: ${counter.countWords(words, stopWords)}" +
                ", unique: ${counter.countUniqueWords(words, stopWords)}" +
                "; average word length: ${counter.averageWordLength(words, stopWords)} characters"
    )
    if (args.isNotEmpty() && args.contains("-index")) {
        val filteredWords = counter.filterWords(words, stopWords).map { it.value }.toMutableList()
        if (filteredWords.isNotEmpty()) {
            println("Index:")
            filteredWords.sort()
            filteredWords.map { println(it) }
        }
    }
}

