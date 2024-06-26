import data.FileReader
import domain.WordCounter
import ui.InputReader

fun main(args: Array<String>) {

    while (true) {
        println("Enter text:")
        val sentence = InputReader().readInput()

        val rawFileContent = FileReader().readFile("stopwords.txt")



        val countedWords = WordCounter().count(sentence, stopWords)
        println("Number of words: $countedWords")
    }


}

