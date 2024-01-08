import java.util.*

class WordsCountPrinterImpl() : WordsCountPrinter {



    override fun printNumberOfWords(args: Array<String>): String {
        val wordsParser = LineByLineWordsParser()
        val wordCounter = WordCounter()
        val wordsToIgnore = wordsParser.getWordsFromFile("stopwords.txt")

        if (args.isNotEmpty()) {
            val fileName = args[0]
            val inputText = wordsParser.getWordsFromFile(fileName).joinToString(" ")
            println("Number of words: ${wordCounter.count(inputText, wordsToIgnore = wordsToIgnore)}")
        } else {
            println("Enter text: ")
            val scanner = Scanner(System.`in`)
            val line = scanner.nextLine()

            println("Number of words: ${wordCounter.count(line, wordsToIgnore = wordsToIgnore)}")
        }
    }
}