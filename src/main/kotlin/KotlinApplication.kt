class KotlinApplication {
}

fun main(args: Array<String>) {
    println("Hello world")

    val wordCounter = WordCounter()
    val wordsParser = LineByLineWordsParser()
    println("Word count: ${wordCounter.count("word the word", wordsToIgnore = wordsParser.getWordsFromFile("stopwords.txt"))}")
}