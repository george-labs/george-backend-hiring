
fun main(args: Array<String>) {
    val wordParser = LineByLineFileWordParser()
    val wordSplitter = WordSplitterImpl()
    val wordCountPrinter = WordCountPrinterImpl(wordParser, wordSplitter, System.out)

    wordCountPrinter.printNumberOfWords(args, wordsToIgnore = wordParser.getWordsFromFile("stopwords.txt"))
}
