import java.util.Scanner

class KotlinApplication {
}

fun main(args: Array<String>) {
    val wordsCountPrinter = WordsCountPrinterImpl()
    wordsCountPrinter.printNumberOfWords(args)
}
