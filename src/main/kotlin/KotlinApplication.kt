class KotlinApplication {
}

fun main(args: Array<String>) {
    val wordParser = LineByLineWordParser()
    val wordCounter = BasicWordCounter()
    val wordCountPrinter = WordCountPrinterImpl(wordParser, wordCounter, System.out)

    wordCountPrinter.printNumberOfWords(args, wordsToIgnore = wordParser.getWordsFromFile("stopwords.txt"))
}
